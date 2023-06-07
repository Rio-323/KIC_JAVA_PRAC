create table album_board1(
    seq int auto_increment primary key,
    subject    varchar(150) not null,
    writer varchar(12) not null,
    mail varchar(50),
    password varchar(12) not null,
    content varchar(2000),
    filename varchar(50),
    filesize int not null,
    latitude varchar(12),
    longitude varchar(12),
    cmt int not null,
    hit int not null,
    wip varchar(15) not null,
    wdate datetime not null
);

create table album_cmt_comment1 (
    seq    int    not null auto_increment primary key,
    pseq    int    not null,   
    writer    varchar(12)    not null,
    password    varchar(12)    not null,
    content    varchar(2000) not null,
    wdate    datetime    not null
);