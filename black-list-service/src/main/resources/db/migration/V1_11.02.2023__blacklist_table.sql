CREATE TABLE IF NOT EXISTS blacklist_table
 (
     id INT8 NOT NULL,
     first_name VARCHAR(30),
     sure_name VARCHAR(30),
     last_name VARCHAR(30),
     birth_date DATE,
     passport_num VARCHAR(15)
);

INSERT INTO blacklist_table (id, first_name, sure_name, last_name, birth_date, passport_num)
VALUES (1, 'Аркадий', 'Петрович', 'Иванов', '1985-12-13', '2547 986532'),
       (2, 'Наталья', 'Витальевна', 'Козлова', '1972-10-25', '9859 145236'),
       (3, 'Равиль', 'Шамильевич', 'Газатулин', '1970-02-14', '8523 471295'),
       (4, 'Светлана', 'Ивановна', 'Канайкина', '1990-05-03', '7842 964785'),
       (5, 'Ахмед', 'Магомедович', 'Абдурахманов', '1992-09-29', '7676 276482');

CREATE SEQUENCE blacklist_table_sequence;