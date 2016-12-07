drop table s_user;
create table s_user(
    s_id int PRIMARY KEY  auto_increment,
    s_username varchar(50),
    s_password varchar(50)
);
select * from s_user;
-- delete from s_user where s_id =2;
-- drop TABLE person
create table s_person(
    p_id int primary key auto_increment,
    p_card_id varchar(50),
    p_name varchar(50),
    p_name_pinyin varchar(50),
    p_used_name varchar(50),
    p_sex varchar(10),
    p_birth date,
    p_political_status varchar(50),
    p_phone varchar(50),
    p_job varchar(50),
    p_hometown varchar(50),
    p_home_address varchar(50),
    p_office_address varchar(50),
    p_relation_with_host varchar(50)
);

select * from s_person;

insert into s_person(p_card_id, p_name, p_name_pinyin, p_used_name, p_sex, p_birth, p_political_status, p_phone, p_job, p_hometown, p_home_address, p_office_address, p_relation_with_host)
VALUE ('1233214','dsadsad','dsadsad','dsadsa','man','1991-12-11','321321','dsjalkd','djsalidjsalid','djilsajdsadij','dsadqt','dsadasd','daskdjla');