create table books(
    seq int not null auto_increment primary key,
    name varchar(100),
    publisher varchar(20),
    author varchar(10),
    price int
);

insert into books values(1, 'HTML + CSS 입문', '삼국미디어', '유비', 30000);
insert into books values(2, 'Javascript + JQuery 입문', '삼국미디어', '관우', 32000);
insert into books values(3, 'Node.js 프로그래밍', '삼국미디어', '장비', 22000);
insert into books values(4, 'HTML5 프로그래밍', '삼국미디어', '조자룡', 30000);




