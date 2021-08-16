CREATE DATABASE employeedb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE employee
(
    employee_id   SERIAL      NOT NULL
        CONSTRAINT employee_pkey
            PRIMARY KEY,
    first_name    varchar(40) NOT NULL,
    last_name     varchar(40) NOT NULL,
    department_id integer     NOT NULL,
    job_title     varchar(50) NOT NULL,
    gender        varchar     NOT NULL,
    date_of_birth date        NOT NULL
);

ALTER TABLE employee
    OWNER TO postgres;

