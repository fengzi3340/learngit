package org.action;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

import org.bean.*;
import org.daoImpl.*;
import org.db.*;

public class BookAddAction {
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private String PublishDate;
	private float Price;
	private String Name;
	private int Age;
	private String Country;
	private boolean flag = false;
	private BookImpl boImpl = new BookImpl();
	public boolean getFlag(){
		return flag;
	}
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	public String getISBN(){
		return ISBN;
	}
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	public String getTitle(){
		return Title;
	}
	public void setTitle(String Title){
		this.Title = Title;
	}
	public int getAuthorID(){
		return AuthorID;
	}
	public void setAuthorID(int AuthorID){
		this.AuthorID = AuthorID;
	}
	public String getPublisher(){
		return Publisher;
	}
	public void setPublisher(String Publisher){
		this.Publisher = Publisher;
	}
	public String getPublishDate(){
		return PublishDate;
	}
	public void setPublishDate(String PublishDate){
		this.PublishDate = PublishDate;
	}
	public float getPrice(){
		return Price;
	}
	public void setPrice(float Price){
		this.Price = Price;
	}
	public String getName(){
		return Name;
	}
	public void setName(String Name){
		this.Name = Name;
	}
	public int getAge(){
		return Age;
	}
	public void setAge(int Age){
		this.Age = Age;
	}
	public String getCountry(){
		return Country;
	}
	public void setCountry(String Country){
		this.Country = Country;
	}
	public String execute() throws Exception {
		System.out.println("%%%%%");
		Author au = boImpl.getByAuthorNameforauthor(Name);
		if(au==null) {
			flag = boImpl.addauthor(AuthorID, Name, Age, Country);
			if(flag==false) return "error";
		}
		flag = boImpl.addbook(ISBN, Title, AuthorID, Publisher, PublishDate, Price);
		if(flag==true)	return "success";
		else	return "error";
	}
}
