CREATE TABLE diary(
	id number PRIMARY KEY,
	content clob,
	label  varchar(40)
	
	);

SELECT * FROM diary;

CREATE TABLE  password(
	id varchar(40) primary key,
	password clob
	);
	
	
SELECT * FROM password;