CREATE SEQUENCE checkbid_table_sequence START 3 INCREMENT 1;


CREATE TABLE IF NOT EXISTS checkbid_table
(
    id int8 primary key not null ,
    bid_number VARCHAR(20),
    is_employed BOOLEAN,
    time_of_employment int4,
    salary double precision,
    loan_payments double precision,
    credit_Amount double precision,
    credit_term double precision,
    percent_year double precision,
    bank_confirm BOOLEAN,
    client_сonfirm BOOLEAN,
    id_client int8 REFERENCES checkclient_table(id)
);



INSERT INTO checkbid_table(id, bid_number, is_employed, time_of_employment, salary, loan_payments, credit_Amount, credit_term, percent_year, bank_confirm, client_сonfirm, id_client )
VALUES (1, 'Д23-0000001', true, 20, 80000, 25500, 300000, 60, 15, true, true, 1 ),
       (2, 'Д23-0000002', true, 25, 70000, 29300, 200000, 48, 17, true, null, 2 );

