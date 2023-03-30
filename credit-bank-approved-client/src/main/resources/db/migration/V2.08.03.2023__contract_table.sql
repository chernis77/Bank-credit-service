CREATE SEQUENCE contract_table_sequence START 3 INCREMENT 1;

CREATE TABLE IF NOT EXISTS contract_table
(
    id int8 PRIMARY KEY NOT NULL,
    contract_number VARCHAR(12),
    credit_amount double precision,
    credit_term double precision,
    percent_year double precision,
    date_contract VARCHAR(30),
    id_client int8 REFERENCES approvedclient_table(id)
);

INSERT INTO contract_table (id, contract_number, credit_amount, credit_term, percent_year,date_contract, id_client)
VALUES (1, 'Д22-0000001', 280000, 24, 15, '2023-02-23', 1 ),
       (2, 'Д22-0000002', 340000, 36, 17, '2023-03-08', 2 );