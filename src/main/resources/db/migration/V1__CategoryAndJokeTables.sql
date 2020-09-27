CREATE TABLE category (

	id int NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL

);

CREATE TABLE joke (

	id int PRIMARY KEY,
	content VARCHAR(400) NOT NULL,
	likes int DEFAULT 0,
	dislikes int DEFAULT 0
);