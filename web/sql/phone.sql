use phone;
drop database PhoneDB;
create database PhoneDB;
use PhoneDB;

	#管理员表
	create table if not exists `user`(
		`u_id` int primary key auto_increment comment'id',
		`user_id` varchar(7)  comment'登入账号',
        `user_name` varchar(20) not null comment'用户名',
        `user_pwd` varchar(20) not null comment'用户登入密码'
    )engine=innodb default charset=utf8;


	insert into `user`(user_id,user_name,user_pwd) values('ldl123','刘大仙','12345');
	insert into `user`(user_id,user_name,user_pwd) values('oyl123','欧大仙','12345');
	insert into `user`(user_id,user_name,user_pwd) values('zdm','张大仙','12345');

	#delete from `user` where `u_id` = '1';


	#select * from `user`;

	#品牌表
	CREATE TABLE IF NOT EXISTS `brand`(
		`b_id` int primary key auto_increment comment'品牌id',
	   `brand_id` varchar(40) comment'品牌编号',
	   `brand_name` VARCHAR(100) NOT NULL comment'品牌名称'
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

	insert into `brand`(brand_id,brand_name) values('HUA_WEI','华为');
	insert into `brand`(brand_id,brand_name) values('MEI_ZU','魅族');
	insert into `brand`(brand_id,brand_name) values('XIAO_MI','小米');
	insert into `brand`(brand_id,brand_name) values('OPPO','OPPO');
	insert into `brand`(brand_id,brand_name) values('VIVO','vivo');
	insert into `brand`(brand_id,brand_name) values('LE_SHI','乐视');
	insert into `brand`(brand_id,brand_name) values('NUO_JI_YA','诺基亚');
	insert into `brand`(brand_id,brand_name) values('SAN_XING','三星');



	#select * from `brand`;


	#手机类型表
	create table if not exists `type`(
		`t_id` int primary key auto_increment comment'手机编号',
		`type_id` int  comment'品牌编号',
		`type_name` varchar(40) comment'手机名称',
        CONSTRAINT type_name_qu UNIQUE (type_name),
        constraint `FK_brand_type` foreign key (`type_id`) references `brand`(`b_id`)
    )engine=innodb default charset=utf8;

		

	
	insert into `type`(type_id,type_name) values(1,'荣耀9i');
	insert into `type`(type_id,type_name) values(2,'荣耀10');
	insert into `type`(type_id,type_name) values(3,'HUAWEIP20');
	insert into `type`(type_id,type_name) values(1,'荣耀7X');
	insert into `type`(type_id,type_name) values(1,'荣耀V10');
	insert into `type`(type_id,type_name) values(2,'魅蓝note2');
	insert into `type`(type_id,type_name) values(2,'魅蓝A5');
	insert into `type`(type_id,type_name) values(3,'魅蓝note6');
	insert into `type`(type_id,type_name) values(4,'小米6X');
	insert into `type`(type_id,type_name) values(4,'小米8SE');
	insert into `type`(type_id,type_name) values(5,'OPPOR17');
	insert into `type`(type_id,type_name) values(7,'OPPOFindX曲面全景屏');
	insert into `type`(type_id,type_name) values(8,'诺基亚NOKIAX6');
	insert into `type`(type_id,type_name) values(8,'诺基亚7Plus');
	insert into `type`(type_id,type_name) values(5,'诺基亚NOKIA105');

	#select * from `type` ;


	#供应商信息表
	create table if not exists `supplier`(
		`supplier_id` varchar(40) primary key comment'供应商编号' ,
		`supplier_name` varchar(100) not null comment'供应商名称',
		`supplier_address` varchar(120) not null comment'供应商地址',
        `supplier_phone` varchar(11) not null comment'供应商联系电话'
    )engine=innodb default charset=utf8;
		
	insert into `supplier` values('E098123','东方手机有限公司','北京朝阳区','13768793091');
	insert into `supplier` values('H094123','南方手机有限公司','珠海斗门区','15728273833');
	insert into `supplier` values('J989343','北方手机有限公司','江西省南昌','17798837748');
	insert into `supplier` values('K988976','西方手机有限公司','山西太原市','13898878475');

	#delete from `supplier` where `supplier_id` = 'E098123';

	#select * from `supplier`;


	#手机信息表
    create table if not exists `phone`(
		`phone_id` int comment'手机id',
		`phone_price` decimal(7,2) comment'价格',
		`phone_state` int not null default 1 comment'状态',   #状态 1：上架中   2:下架  3：无货
        `phone_supplier` varchar(40) comment'供应商',
        `phone_describe` varchar(1000) default '暂时没有描述' comment'描述',
        check (`phone_price` > 0),
        constraint `FK_type_phone` foreign key (`phone_id`) references `type`(`t_id`),
        constraint `FK_supplier_phone` foreign key (`phone_supplier`) references `supplier`(`supplier_id`)
    )engine=innodb default charset=utf8;


	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(15,1699.00,1,'E098123','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(13,2899.00,1,'H094123','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(6,1499.00,1,'J989343','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(8,3299.00,1,'E098123','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(7,1799.00,1,'J989343','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(1,1399.00,2,'E098123','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(11,1899.00,1,'E098123','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(3,999.00,1,'K988976','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(4,3699.00,2,'K988976','暂时没有描述');
	insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(5,3199.00,1,'J989343','暂时没有描述');

	#select * from `phone`;

	#库存表
	create table if not exists `stock`(
		`stock_id`  int comment'手机id',
		`stock_count` int  comment'库存数量',
        check (`stock_count` > 0),
        constraint `FK_stock_phone` foreign key (`stock_id`) references `phone`(`phone_id`)        
    )engine=innodb default charset=utf8;

	

	insert into `stock` values(15,200);
	insert into `stock` values(3,400);
	insert into `stock` values(4,100);
	insert into `stock` values(7,700);
	insert into `stock` values(11,500);
	insert into `stock` values(1,1200);
    
    #select * from `stock`;
    
	#进货表
	create table if not exists `purchase`(
		`purchase_u_id` int comment'工作人员的id',
		`purchase_id`  int comment'手机id',
		`purchase_count` int default 0 comment'进货数量',
        `purchase_time` datetime default NOW() comment'进货时间',
        `purchase_decribe` varchar(1000) default'暂时没有描述' comment'描述',
        check(`purchase_count` > 0),  #进货数量大于0
        constraint `FK_purchase_phone` foreign key (`purchase_id`) references `phone`(`phone_id`)      
    )engine=innodb default charset=utf8;
    
    
    #数据录入
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(1,1,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(1,15,400);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(1,13,700);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(2,3,200);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(3,5,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(3,7,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(3,8,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(2,4,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(1,6,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(1,1,300);
    insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`) values(2,1,300);
    
    #select * from `purchase`;
    
    #delete from `purchase` where `purchase_u_id`=1 and `purchase_id`=1 and `purchase_decribe`='暂时没有描述';
    
    
    
	#退货表
	create table if not exists `returnGoods`(
		`returnGoods_u_id` int comment'退货管理员id',
		`returnGoods_id`  int primary key comment'手机id',
		`returnGoods_count` int default 0 comment'进货数量',
        `returnGoods_time` datetime default NOW() comment'进货时间',
        `returnGoods_decribe` varchar(1000) default'暂时没有描述' comment'描述',
        check(`purchase_count` > 0), 
        constraint `FK_returnGoods_phone` foreign key (`returnGoods_id`) references `stock`(`stock_id`)      
    )engine=innodb default charset=utf8;
    
    insert into `returnGoods`(`returnGoods_u_id`,`returnGoods_id`,`returnGoods_count`,`returnGoods_decribe`) values(1,1,300,'质量不达标');
    insert into `returnGoods`(`returnGoods_u_id`,`returnGoods_id`,`returnGoods_count`,`returnGoods_decribe`) values(1,15,200,'手机故障问题');

	#select * from stock;
    #select * from `user`;
    #select * from purchase;
	#select * from returnGoods;
    
    #update `user` set `user_id`='ldg123',`user_name` = '刘大哥',`user_pwd`='12345' where `user_id`='ldl123'
		
        
	
    





