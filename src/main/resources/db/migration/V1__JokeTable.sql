CREATE TABLE joke (

	id UUID NOT NULL PRIMARY KEY,
	content VARCHAR(400) NOT NULL,
	likes int DEFAULT 0,
	dislikes int DEFAULT 0
);