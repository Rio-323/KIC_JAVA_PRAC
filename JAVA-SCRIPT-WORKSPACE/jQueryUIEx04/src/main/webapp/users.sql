create table users (
    seq int not null auto_increment primary key,
    name varchar(20) not null,
    password varchar(20) not null,
    email varchar(100),
    address varchar(150),
    wdate datetime
);

insert into users values(0, '홍길동', '1234', 'test@test.com', '서울시 강남구', now());