package org.bean;
import java.io.Serializable;
public class Book implements Serializable {
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private String PublishDate;
	private float Price;
	public String getISBN() {
		return ISBN;
	} 
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getTitle() {
		return Title;
	} 
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public int getAuthorID() {
		return AuthorID;
	} 
	public void setAuthorID(int AuthorID) {
		this.AuthorID = AuthorID;
	}
	public String getPublisher() {
		return Publisher;
	} 
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	} 
	public void setPublishDate(String PublishDate) {
		this.PublishDate = PublishDate;
	}
	public float getPrice() {
		return Price;
	} 
	public void setPrice(float Price) {
		this.Price = Price;
	}
}
