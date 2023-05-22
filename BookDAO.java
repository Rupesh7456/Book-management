package com.takeo.dao;



import java.util.List;

import com.takeo.model.Book;

public interface BookDAO {

public String register(Book book);

public List<Book>viewRegisters();

public boolean verifyUsernameAndPassword(String uname,String pass);
	
}
