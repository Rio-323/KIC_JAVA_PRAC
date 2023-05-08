create table member1 (
    seq int not null auto_increment primary key,
    id varchar(12) not null,
    password varchar(12) not null,
    name varchar(12) not null,
    mail varchar(50),
    grade char(1) not null,
    wdate datetime not null
);
insert into member1 values(0, 'tester', '1234', '이름', 'test@test.com', 'A', now());