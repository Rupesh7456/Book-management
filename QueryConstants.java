package com.takeo.query;

public interface QueryConstants {
	
public String USER_INSERT_QUERY="insert into login(bname,btype,bprice,username,password)values(?,?,?,?,?)";

public String USER_SELECT_QUERY="select* from login";


public String USER_VALID_QUERY="select* from login where uname=? and password=?";
}
