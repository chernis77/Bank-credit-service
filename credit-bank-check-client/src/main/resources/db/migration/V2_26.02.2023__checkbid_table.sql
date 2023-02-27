CREATE TABLE IF NOT EXISTS checkbid_table
(
    id int8 primary key not null ,
    bid_number VARCHAR(20),
    is_employed BOOLEAN,
    time_of_employment int4,
    salary int8,
    loan_payments int8,
    credit_Amount int8,
    credit_term int4,
    percent_year int4,
    bank_confirm BOOLEAN,
    client_сonfirm BOOLEAN,
    id_client int8 REFERENCES checkclient_table(id)
);

INSERT INTO checkbid_table
VALUES (1, 'Д-0010001', true, 20, 80000, 25500, 300000, 60, 15, true, true, 1 ),
       (2, 'Д-0010002', true, 25, 70000, 29300, 200000, 48, 17, true, null, 2 );

CREATE SEQUENCE checkbid_table_sequence;