
insert into customer  (id,FIRSTNAME , LASTNAME) values (1,'장', '성일');
insert into customer  (id,FIRSTNAME , LASTNAME) values (2,'장', '성일2');
insert into account (id,expiry_date, customer_id) values(1,now(),1);
insert into account (id,expiry_date, customer_id) values(2,now(),1);
insert into account (id,expiry_date, customer_id) values(3,now(),2);

insert into bag (id,name, create_at) values(1,'내꺼야', now());
insert into account_bag (account_id, bag_id, id) values (1,1,1);
