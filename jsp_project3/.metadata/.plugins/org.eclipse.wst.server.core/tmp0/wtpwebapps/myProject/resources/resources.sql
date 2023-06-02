create table comment(
	cno int not null auto_INCREMENT,
	bno int DEFAULT 0,
	writer varchar(100) DEFAULT "unknown",
	content varchar(1000) not null,
	regdate datetime DEFAULT now(),
	primary key(cno));
	
-- 2023-05-25
	alter table board add column image text;