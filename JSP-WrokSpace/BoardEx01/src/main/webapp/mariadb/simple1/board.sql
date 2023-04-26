번호                      
seq     int     not null    primary key, auto_increment(마리아디비)
제목                       
subject varchar(150) not null
글쓴이                 
writer varchar(12) not null
이메일                
mail varchar(50)
비밀번호            
password varchar(12) not null
내용                      
content varchar(2000)
이모티콘
emot char(2) not null
조회수                 
hit int not null
아이피               
wip varchar(15) not null
등록일                
wdate datetime not null 



사용자 생성
create user board@localhost identified by '1234';
create user board@'%' identified by '1234';
grant all privileges on *. * to board@localhost;
grant all privileges on board. * to board@localhost;

// board 계정 로그인 후
create database board;

create table emot_board (
    seq int not null auto_increment primary key, 
    subject varchar(150) not null,
    writer varchar(12) not null,
    mail varchar(50),
    password varchar(12) not null,
    content varchar(2000),
    emot char(2) not null,
    hit int not null,
    wip varchar(15) not null,
    wdate datetime not null 
);



INSERT INTO board VALUES (0, '제목', '이름', 'test@test.com', '1234', '내용', '0', '000.000.000.000', now());
