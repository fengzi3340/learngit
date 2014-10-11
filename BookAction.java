package org.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.bean.*;
import org.daoImpl.*;
import org.db.*;

import java.io.*;
public class BookAction extends ActionSupport {
	private String authorname;
	private List<Book> list;
	private BookImpl boImpl = new BookImpl();
	public List<Book> getList(){
		return list;
	}
	public void setList(List<Book> list){
		this.list = list;
	}
	public String getAuthorname(){
		return authorname;
	}
	public void setAuthorname(String authorname){
		this.authorname = authorname;
	}
	public String execute() throws Exception {
		Author au = boImpl.getByAuthorNameforauthor(authorname);
		if(au==null) return "e";
		else {
			int authorid = au.getAuthorID();
			list = boImpl.getAuthorIDforBook(authorid);
			return "s";
		}
	}
}
