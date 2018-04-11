create table t_book(
	id int primary key auto_increment comment '主键',
	bookname varchar(200) not null comment '书名',
	author varchar(100) not null comment '作者',
	desc varchar(200) comment '书简简要',
	info text comment '书的信息'
);