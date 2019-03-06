
CREATE TABLE tbl_user (
    id              NUMBER             PRIMARY KEY,
    userId          nVARCHAR2(30)      NOT NULL,
	userName        nVARCHAR2(30)      NOT NULL,
	password        nVARCHAR2(30)      NOT NULL,
    birth           VARCHAR2(10)       NOT NULL,
	height          nVARCHAR2(30)      NOT NULL,
	weight          nVARCHAR2(30)      NOT NULL,
	activityindex   nVARCHAR2(30)      NOT NULL
);

DROP TABLE tbl_user;

CREATE SEQUENCE SEQ_USER START WITH 1 INCREMENT BY 1;

CREATE TABLE tbl_kcal (
    id              NUMBER             PRIMARY KEY,
    cate            nVARCHAR2(50)      NOT NULL,
    cate_code       VARCHAR2(3)        NOT NULL, 
    foodName        nVARCHAR2(125)     NOT NULL,
	oneofsupply     VARCHAR2(50)       NOT NULL,
	foodkcal        VARCHAR2(20)       NOT NULL    
);

ALTER TABLE tbl_kcal RENAME COLUMN Kcal to foodkcal;

DESC tbl_kcal;

INSERT INTO tbl_kcal VALUES(0,'¹ä·ù','001','±èÄ¡ººÀ½¹ä','100','600');

DESC tbl_kcal;

SELECT * FROM tbl_kcal ORDER BY id;
SELECT COUNT(*) FROM tbl_kcal;

SELECT * FROM tbl_user;

SELECT * FROM tbl_userselect;

SELECT cate FROM tbl_kcal GROUP BY cate;

alter table tbl_kcal add  cate      nVARCHAR2(50)       NOT NULL;

drop table tbl_kcal;

SELECT * FROM tbl_user;

SELECT * FROM tbl_kcal WHERE cate = "¹ä·ù";

delete FROm tbl_kcal;

CREATE TABLE tbl_userselect(
    userId          nVARCHAR2(30)      PRIMARY KEY,
    foodName        nVARCHAR2(125)     NOT NULL,
	oneofsupply     VARCHAR2(50)       NOT NULL,
	Kcal            VARCHAR2(20)       NOT NULL,
    u_date          VARCHAR2(10)
);