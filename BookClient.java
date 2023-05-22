package com.takeo;

import java.util.List;
import java.util.Scanner;

import com.takeo.dao.impl.BookDAOImpl;
import com.takeo.model.Book;



public class BookClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		BookDAOImpl daoImpl=new BookDAOImpl();
		
		while(true) {
System.out.println("========================================================");

System.out.println("                 1)Register                             ");

System.out.println("                 2)Login                                ");

System.out.println("                 3)viewUsers                            ");

System.out.println("                 4)Exist                                ");


System.out.println("========================================================");

				
		
System.out.println("Enter the choice");
		
		
int choice=sc.nextInt();
				
switch(choice) {
case 1:
	System.out.println("Enter the book name");
	String bname=sc.next();
	
	System.out.println("Enter the book type");
	String btype=sc.next();
	
	System.out.println("Enter the book price");
	int bprice=sc.nextInt();
	
	System.out.println("Enter the Username");
	String uname=sc.next();
	
	System.out.println("Enter the password");
	String pass=sc.next();
	
	Book book=new Book(bname,btype,bprice,uname,pass);
	
	
	String msg=daoImpl.register(book);
	if (msg!=null)
		System.out.println(msg);
	else
		System.out.println(msg);
	
	break;
	
case 2:
	System.out.println("Enter the username");
	String User=sc.next();
	
	System.out.println("Enter the password");
	String passWord=sc.next();
	
	boolean verifyUsernameAndPassword=daoImpl.verifyUsernameAndPassword(User, passWord);
	
	if (verifyUsernameAndPassword) {
	List<Book>viewRegisters=daoImpl.viewRegisters();
	
	
	for(Book b:viewRegisters) {
		System.out.println(b.getBid()+ "\t" + b.getBname() + "\t" + b.getBtype() + "\t" + b.getBprice());
	}
	}
		else {
		System.out.println("Invalid User or password");
	
		}
	
	break;
	
	
case 3:
	List<Book>viewRegisters=daoImpl.viewRegisters();
	for(Book bo:viewRegisters) {
		System.out.println(bo.getBid() + "\t" + bo.getBname() + "\t" + bo.getBtype() + "\t" + bo.getBprice());
		
	}
	break;
	
case 4:
	System.out.println("Thanks for visiting us");
	System.exit(0);
	
	default:
		System.out.println("Choice between 1 to 4");
}//end of switch choice






}

}
}