-- 2023-05-26 db생성
create DATABASE yangdb;
-- 2023-05-26 member 테이블 생성
create table member(
	mno int not null auto_increment,
	id VARCHAR(20),
	password VARCHAR(40),
	name VARCHAR(15),
	age int,
	email varchar(50),
	regdate datetime DEFAULT now(),
	lastlogin datetime DEFAULT null,
	PRIMARY KEY(mno));
-- 2023-05-26 board 테이블 생성
create table board(
	bno int not null auto_INCREMENT,
	title varchar(30),
	writer varchar(20),
	content varchar(500),
	regdate datetime default now(),
	count int default 0,
	PRIMARY KEY(bno));