create database linglanflowershop default character set utf8;
use linglanflowershop;

create table shop(
	id int not null auto_increment,
    shopname varchar(20) not null,
    username varchar(10) not null,
    passw varchar(12) not null,
    tel varchar(11) default null,
    address varchar(30) default null,
    primary key(id)
)engine=InnoDB default charset=utf8;

create table category(
	id int not null auto_increment,
    catename varchar(50) not null,
    primary key(id)
)engine=InnoDB default charset=utf8;

create table product(
	id int not null auto_increment,
	productname varchar(20) not null,
	summary varchar(50) default null,
	price double not null,
	stock int not null,
	s_id int not null,
	c_id int not null,
	recommend int not null,
    primary key(id),
    constraint fk_product_category foreign key (c_id) references category(id),
    constraint fk_product_shop foreign key(s_id) references shop(id)
)engine=InnoDB default charset=utf8;

select * from product;
select count(*) from product where s_id=2 and recommend=3;

create table productimage (
  id int not null auto_increment,
  p_id int ,
  primary key (id),
  constraint fk_productimage_product foreign key (p_id) references product (id)
) engine=innodb default charset=utf8;

alter table productimage drop imagetype;

create table member(
	id	varchar(10) not null,
	passw varchar(12) not null,
	username varchar(20) not null,
	tel varchar(11) not null,
	address varchar(30) not null,
    primary key(id)
) engine=innodb default charset=utf8;


select * from member;

use linglanflowershop;
insert into member(id,passw,username,tel,address) values("aaaa","123456","kris","15044703720","昆区");

create table orderlist(
	id varchar(30) not null,
	m_id varchar(10) not null,
	message varchar(100),
	createDate datetime not null,
	payDate datetime,
	deliveryDate datetime,
	comfirmDate datetime,
	orderstatus int,
    primary key(id),
    constraint fk_orderlist_member foreign key(m_id) references member(id)
)engine=innodb default charset=utf8;

select * from orderlist where m_id='one1996' and orderstatus=4;

delete from orderlist;

select * from orderlist;
drop table orderlist;
alter table orderlist change prderstatus orderstatus int;

create table orderitem(
	id int not null auto_increment,
	o_id varchar(30),
	p_id int not null,
	m_id varchar(10) not null,
    s_id int not null,
	itemnumber int null,
    primary key(id),
    constraint fk_orderitem_shop foreign key(s_id) references shop(id),
    constraint fk_orderitem_member foreign key(m_id) references member(id),
    constraint fk_orderitem_orderlist foreign key(o_id) references orderlist(id),
    constraint fk_orderitem_product foreign key(p_id) references product(id)
)engine=innodb default charset=utf8;



use linglanflowershop;
select * from orderitem;
select s_id,count(s_id) quantity from orderitem group by s_id order by count(s_id) desc;
delete from orderitem where s_id=2;

create table coupon(
	id int not null auto_increment,
	s_id int not null,
	reducePrice double not null,
	limitPrice double not null,
    primary key(id)
)engine=innodb default charset=utf8;

select * from coupon;

drop table comment;
select * from comment;

create table complain(
	id int not null auto_increment,
	m_id varchar(10) not null,
	content varchar(500),
	commitDate datetime not null,
    primary key(id),
    constraint fk_complain_member foreign key(m_id) references member(id)
)engine=innodb default charset=utf8;

show tables;

select * from member;

insert into category(catename) value("鲜花");
insert into category(catename) value("绿植");
insert into category(catename) value("多肉");
insert into category(catename) value("种植工具");
insert into category(catename) value("肥料");

select * from complain;

select id from shop where username="crush123";

select * from product;
select * from shop;
select * from productimage;
select * from product  order by recommend desc;