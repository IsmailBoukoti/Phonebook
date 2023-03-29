CREATE TABLE IF NOT EXISTS springbootjdbc.contacts (
	Id INT PRIMARY KEY auto_increment NOT NULL,
	name varchar(255) NULL,
    surname varchar(255) NULL,
    address varchar(255) NULL,
	email varchar(255) NULL,
	phonenumber varchar(255) NULL
)