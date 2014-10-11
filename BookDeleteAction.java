package org.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.bean.*;
import org.daoImpl.*;
import org.db.*;

public class BookDeleteAction {
	private boolean flag = false;
	private String bookname;
	private BookImpl boImpl = new BookImpl();
	public boolean getFlag(){
		return flag;
	}
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	public String getBookname(){
		return bookname;
	}
	public void setBookname(String bookname){
		this.bookname = bookname;
	}
	public String execute() throws Exception {
		flag = boImpl.delete(bookname);
		if(flag==true)	return "success";
		else	return "error";
	}
}
