    CREATE TABLE CARRIERS(
        code Long PRIMARY KEY,
        name Varchar(255),
        zip_code_start Integer,
        zip_code_end Integer,
        delivery_limit_days Integer Default 2
    );