## Информация о приложении Bank credit service 

Приложение **Bank credit service** предназначено для обработки кредитных заявок, расчета кредитного потенциала клиента, 
регистрации кредитных договоров в базе данных и выдачи информации о заключенном кредитном договоре с графиком платежей.

   Приложение представляет собой REST API с микросервисной архитектурой на базе SpringBoot, версия 3.0.2. 
Микросервисы зарегистрированы на Eureka Server (модуль ***credit-bank-server***) , маршрутизация запросов производится 
через API Gateway (модуль ***api-client***). Взаимодействие между микросервисами производится с помощью RestTemplate. 
В микросервисах используются реляционные базы данных PostgreSQL, взаимодействие с которыми производится посредством 
Spring Data JPA, реализующим Hibernate. Базы данных работают из контейнеров Docker Desktop. Создание таблиц и заполнение
первичной информации в базы данных производится из SQL- скриптов с помощью  Flyway migration. Маппинг полей между 
сущностями Entity и DTO производится с помощью MapStruct.  Также в микросервисах написаны интеграционные и Unit тесты.

   Приложение состоит из следующих модулей:

***credit-bank-server*** - в нём развернут Eureka Server; <br/>
***api-client*** - в нём развернут API Gateway;<br/>
***credit-bank-first-client*** - выполняет валидацию заявки. В случае некорректного заполнения каких-либо полей выдаёт 
соответствующее сообщение, в случае, если заявка заполнена корректно, пересылает заявку на ***credit-bank-check-client***;<br/>
***black-list-service*** - аналог бюро кредитных историй. Содержит таблицу базы данных (БД) blacklist_db.public.blacklist_table
со списком людей с плохой кредитной историей;<br/>
***credit-bank-check-client*** - производит обработку поступившей заявки. Исходя из информации, содержащейся в заявке клиента 
и наличия/отсутствия информации о клиенте в БД на ***black-list-service***, выдает сообщение о принятом банком решении. 
Выдает либо отказ с обоснованием причины, либо сообщение об одобрении заявки с информацией о согласованной сумме , 
процентной ставке и номере заявки. В случае, если запрашиваемая сумма превышает лимит, рассчитанный для данного клиента,
выдает сообщение о максимально возможной сумме кредита.   Содержит таблицы БД:  <br/>
check_client_db.public.checkbid_table и check_client_db.public.checkclient_table. <br/>  
+ check_client_db.public.checkbid_table  - содержит информацию об одобренных банком заявках.<br/>
+ check_client_db.public.checkclient_table - содержит информацию о клиентах.<br/>

В случае утверждения банком заявки, вносится соответствующая запись в эти таблицы.
Далее, при получении от клиента его согласия на заключение кредитного договора, отсылает утвержденную заявку на 
***credit-bank-approved-client***.<br/>
***credit-bank-approved-client*** - получает утвержденную банком и клиентом заявку из ***credit-bank-check-client***  
и вносит в базу данных записи о зарегистрированном кредитном договоре. Содержит таблицы БД:<br/>
approved_client_db.public.contract_table и  approved_client_db.public.approvedclient_table.<br/>

+ approved_client_db.public.contract_table - содержит информацию о заключенных договорах.<br/>
+ approved_client_db.public.approvedclient_table - содержит информацию о клиентах.<br/>
 
При получении запроса с номером кредитного договора выдает из БД информацию о договоре и график платежей.

###   Описание работы приложения

Процесс работы приложения состоит из трех этапов:<br/>  
**1й этап** - подача заявки на кредит: при запросе на http://localhost:8099/fill/sendform, на FormController сервиса  ***credit-bank-first-client*** от клиента поступает кредитная заявка, содержащая следующие поля:<br/>
String firstName - имя клиента <br/>
String surName- отчество <br/>
String lastName - фамилия <br/>
String passportNum -номер паспорта <br/>
String isEmployed - трудоустроен ли клиент (true/false) <br/>
String timeOfEmployment - сколько времени клиент трудоустроен, мес. <br/>
String salary - зарплата клиента, руб/мес. <br/>
String loanPayments - суммарный размер имеющихся ежемесячных кредитных платежей, руб/мес. <br/>
String creditAmount - запрашиваемый размер кредита, руб. <br/>
String creditTerm - запрашиваемый срок кредита, мес. <br/>
Заявка проходит валидацию на корректность заполненных полей. В случае некорректного заполнения поля, об этом выдается 
соответствующее сообщение: <br/>
![Ошибка валидации](/images/Validation_fault.JPG)<br/>
Если поля заявки заполнены корректно, заявка передается на сервис  ***credit-bank-check-client*** (в CheckController,  
метод  checkClientResponse(@RequestBody RequestFormDTO requestFormDTO) ).  Оттуда отправляется запрос с номером 
паспорта клиента на сервис ***black-list-service*** (в BlackListController) ,  который возвращает ответ(true/false), 
содержится ли заявитель в БД неблагонадежных клиентов (таблица blacklist_table). Далее, в соответствии с заложенными условиями,
выдается ответ банка. <br/>

>Таблица blacklist_table:<br/>
> 
![](/images/Blacklist_table_annot.JPG)<br/>

Если клиент находится в БД на ***black-list-service***, а также не трудоустроен, выдется отказ в кредите:<br/>
![Отказ в кредите](/images/Denial_of_credit.JPG)<br/>

Если клиент находится в БД на ***black-list-service***, и трудоустроен менее 12 месяцев, также выдется отказ в кредите.<br/>

В случае, если запрашиваемая сумма больше той, которая вычисляется как максимально доступная для заявителя, выдается 
сообщение с информацией о максимально доступной сумме:<br/>

![Макс. доступная сумма](/images/Max_avalable_amount.JPG)<br/>

Процентная ставка зависит от срока работы клиента и наличия его данных в
БД на ***black-list-service***.<br/>
В случае, если запрашиваемая сумма не превышает максимально допустимую для заявителя, выдается ответ с одобрением заявки:<br/>

![Одобрение заявки](/images/Bid_approval.JPG)<br/>

и производится запись в таблицы БД на сервисе ***credit-bank-check-client*** :<br/>

>checkbid_table  :<br/>
>
![](/images/Checkbid_table_1_annot.JPG)<br/>
при этом, в ячейке bank_confirm установлено значение true, а в client_confirm - null. Значение номера заявки 
в ячейке bidNumber увеличивается на единицу по отношению к значению в предыдущей строке.<br/>

>checkclient_table :<br/>
>
![](/images/Checkclient_table_annot.JPG)<br/>
Запись в checkclient_table производится только в том случае, если данные об этом клиенте отсутствуют в этой таблице.<br/>
В том случае, если данные клиента уже содержатся в таблице checkclient_table и подается заявка, в которой фамилия, имя 
или отчество не соответствуют номеру паспорта в данной таблице, выдается соответствующее сообщение, при этом записи 
в таблицы БД не производятся:<br/>
![](/images/FIO_doesnt_match_passport.JPG)<br/>

**2й этап** – подтверждение клиентом своего согласия на заключение договора и регистрация данных о заключенном договоре 
и о клиенте в БД на сервисе ***credit-bank-approved-client*** :  при запросе от клиента с номером утвержденной банком 
заявки на http://localhost:8099/check/contractmessage , данный параметр поступает в CheckController 
(метод  confirmBidAndCreateContract(String bidNumber) )   сервиса ***credit-bank-check-client***. Производится проверка 
значения поля client_confirm в таблице checkclient_table. Если значение поля – null, то его значение изменяется на true 
и на сервис ***credit-bank-approved-client*** отправляется TransferBidToApproveDTO с данными утвержденной заявки из 
таблиц checkbid_table и checkclient_table.  TransferBidToApproveDTO поступает в ApprovedController 
(метод saveBidToContract(TransferBidToApproveDTO  transferBidToApproveDTO)) сервиса
***credit-bank-approved-client***. Производятся записи в таблицы БД сервиса ***credit-bank-approved-client*** - в 
contract_table и в approvedclient_table и, таким образом, регистрируется заключение кредитного договора.

>contract_table:<br/>

![](/images/Contract_table_annot.JPG)<br/>
Значение в ячейке contract_number (номер договора)  соответствует номеру утвержденной заявки (поле String bidNumber 
из TransferBidToApproveDTO).<br/> 

>approvedclient_table:<br/>

![](/images/Approvedclient_table_annot.JPG)<br/>

Выводится сообщение о заключенном кредитном договоре:<br/>

![Договор заключен](/images/Сontract_is_concluded.JPG)<br/>

Запись в approvedclient_table производится только, если данные об этом клиенте отсутствуют в этой таблице.<br/>

В том случае, если в запросе содержится номер заявки, договор по которой уже зарегистрирован, выдается сообщение, 
что договор по данной заявке уже создан:<br/>

![Договор уже создан](/images/Contract_already_exists.JPG)<br/>

**3й этап** – получение информации о заключенном договоре и графика платежей: при запросе от клиента с номером 
заключенного договора на http://localhost:8099/testapproved/contractinfo , данный параметр поступает в 
ContractInfoController (метод getContractInfo(String contractNumber) ) сервиса ***credit-bank-approved-client***. 
В ответ возвращается информация о кредитном договоре и график платежей:<br/>

![График платежей ч.1](/images/Payments_shedule_1.JPG)<br/>
![График платежей ч.2](/images/Payments_shedule_2.JPG)<br/>

Если в запросе приходит номер договора, который отсутствует в contract_table, выводится соответствующее сообщение:<br/>

![Договора с таким номером не существует](/images/Contract_doesnt_exsist.JPG)<br/>













