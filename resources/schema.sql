CREATE TABLE category
(
	id NUMBER(4) NOT NULL;
	name VARCHAR2(10);
)

ALTER TABLE category ADD CONSTRAINT cat_pk PRIMARY KEY (id);

CREATE TABLE member (
    userId VARCHAR2(18) NOT NULL,
    name VARCHAR2(10),
    nickname VARCHAR2(10),
    password VARCHAR2(15),
    phone VARCHAR2(12),
    email VARCHAR2(25),
    gender VARCHAR2(5),
    birth DATE,
    joinDate DATE,
    interest VARCHAR(10),
    region VARCHAR2(10)
);

ALTER TABLE member ADD CONSTRAINT m_pk PRIMARY KEY (memberId);
