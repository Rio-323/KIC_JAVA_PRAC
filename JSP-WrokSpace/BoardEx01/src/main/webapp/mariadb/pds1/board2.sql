create table pds_board (
    seq int not null auto_increment primary key, 
    subject varchar(150) not null,
    writer varchar(12) not null,
    mail varchar(50),
    password varchar(12) not null,
    content varchar(2000),
    filename varchar(50),
    filesize int,
    hit int not null,
    wip varchar(15) not null,
    wdate datetime not null 
);

INSERT into pds_board values (0, '제목', '이름', 'test@test.com', '1234', '내용', 'test.txt', 0, 0, '000.000.000.000', now())
