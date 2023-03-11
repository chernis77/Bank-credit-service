CREATE TABLE IF NOT EXISTS approvedclient_table
    (
       id int8 PRIMARY KEY NOT NULL,
       firstname VARCHAR(25),
       surname VARCHAR(25),
       lastname VARCHAR(25),
       passportnum VARCHAR(12)
    ) ;

INSERT INTO approvedclient_table(id, firstname, surname, lastname, passportnum)
VALUES (1, 'Николетта', 'Николаевна', 'Николаева', '2738 437915'),
       (2, 'Александра', 'Александровна', 'Александрова', '2791 672845');

CREATE SEQUENCE approvedclient_table_sequence;