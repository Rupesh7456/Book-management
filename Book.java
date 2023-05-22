package com.takeo.model;

public class Book {
private int bid;
private String bname;
private String btype;
private int bprice;
private String username;
private String password;
public Book(String bname, String btype, int bprice, String username, String password) {
	super();
	this.bname = bname;
	this.btype = btype;
	this.bprice = bprice;
	this.username = username;
	this.password = password;
}
public Book(int bid, String bname, String btype, int bprice, String username, String password) {
	super();
	this.bid = bid;
	this.bname = bname;
	this.btype = btype;
	this.bprice = bprice;
	this.username = username;
	this.password = password;
}

//parameterized constructor
public Book() {
	//TODO Auto_generated constructor stub
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBtype() {
	return btype;
}
public void setBtype(String btype) {
	this.btype = btype;
}
public int getBprice() {
	return bprice;
}
public void setBprice(int bprice) {
	this.bprice = bprice;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}