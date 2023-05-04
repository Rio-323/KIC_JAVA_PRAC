create table rep_board (
    seq int not null auto_increment primary key, 
    grp int not null,
    grps int not null,
    grpl int not null,
    subject varchar(150) not null,
    writer varchar(12) not null,
    mail varchar(50),
    password varchar(12) not null,
    content varchar(2000),
    hit int not null,
    wip varchar(15) not null,
    wdate datetime not null 
);

INSERT into rep_board values (0, 1, 0, 0, '제목', '이름', 'test@test.com', '1234', '내용', '0', '000.000.000.000', now())

INSERT into rep_board values (0, last_insert_id() + 1, 0, 0, '제목', '이름', 'test@test.com', '1234', '내용', '0', '000.000.000.000', now())