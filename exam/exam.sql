CREATE DATABASE coders;
use coders;
CREATE TABLE company(
	id int(11) auto_increment primary key,
    name varchar(255),
    sector varchar(255),
    ubication varchar(255),
    contact varchar(255)
);
CREATE TABLE coder(
	id int(11) auto_increment primary key,
    name varchar(255),
    surname varchar(255),
    identity varchar(255) unique,
    cohorte int(11),
    cv text
);
ALTER TABLE coder 
add column clan varchar(255);

CREATE TABLE vacant(
	id int(11) auto_increment primary key,
    company_id int(11),
    CONSTRAINT company_id_fk
    foreign key(company_id) 
    REFERENCES company(id) on delete cascade,
    title varchar(255),
    description text,
    duration varchar(255),
    state varchar(50) 
);
ALTER TABLE vacant 
add column tecnology varchar(255);

CREATE TABLE hiring(
	id int(11) auto_increment primary key,
    vacant_id int(11),
	CONSTRAINT vacant_id_fk
    foreign key(vacant_id) 
    REFERENCES vacant(id) on delete cascade,
    coder_id int(11),
	CONSTRAINT coder_idfk
    foreign key(coder_id) 
    REFERENCES coder(id) on delete cascade,
    date_aplication timestamp,
    state varchar(255),
    salary decimal(10,2)
);
