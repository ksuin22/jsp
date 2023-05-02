package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProdVO {
	
	
//	CREATE TABLE tbl_product (
//			prod_no number(4) primary key,
//			prod_name VARCHAR(20) not null,
//			prod_exp VARCHAR(1000),
//			price number(10) not null,
//			sale_price number(10),
//			review varchar(500) 
//			);
	
	
	private int prodNo;
	private String prodName;
	private String prodExp;
	private double price;
	private double salePrice;
	private String review;
	private String image;

}
