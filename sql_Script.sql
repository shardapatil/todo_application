use CDAC_Adv_Java;

create table user(
	uid int primary key auto_increment,
    uname varchar(50),
    pass varchar(50)
);

insert into user(uname,pass) values('sharda','abc'),
('nikhil','nikh');

select * from user;

select * from user where uname = 'sharda' and pass = 'abc';

-- todo app
create table todo
(
	todoid int primary key auto_increment,
    description varchar(100),
    targetdate date
);

select * from todo;

show tables;
