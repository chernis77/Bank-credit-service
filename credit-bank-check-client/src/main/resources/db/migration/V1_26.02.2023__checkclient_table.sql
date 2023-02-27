CREATE TABLE IF NOT EXISTS checkclient_table
(
    id int8 primary key not null ,
    first_name VARCHAR(25),
    sure_name VARCHAR(25),
    last_name VARCHAR(25),
    passport_num VARCHAR(12)
);

INSERT INTO checkclient_table(id, first_name, sure_name, last_name, passport_num)
VALUES(1, 'Иван', 'Иванович', 'Иванов', '9875 354292'),
      (2, 'Семён', 'Семёнович', 'Семёнов', '2793 452188');

CREATE SEQUENCE checkclient_table_sequence;
