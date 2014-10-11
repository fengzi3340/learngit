package org.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.bean.*;
import org.daoImpl.*;
import org.db.*;

public class BookListAction {
	private String bname;
	private List<Book> list;
	private BookImpl boImpl = new BookImpl();
	public List<Book> getList(){
		return list;
	}
	public void setList(List<Book> list){
		this.list = list;
	}
	public String getbname(){
		return bname;
	}
	public void setbname(String bname){
		this.bname = bname;
	}
	public String execute() throws Exception {
		list = boImpl.getAll();
		return "ss";
	}
}
