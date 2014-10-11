package org.daoImpl;
import java.util.*;

import org.bean.*;
import org.db.*;
public class BookImpl{
	private ControlDB controlDB = ControlDB.getInstance();
	//����ͼ�����
	public boolean addbook(String ISBN,String Title,int AuthorID,String Publisher,
			String PublishDate,float Price) throws Exception {
		boolean flag = true;
		String sql = "insert into Book values('"+ISBN+"','"+Title+"','"+AuthorID+"','"+Publisher+"','"+PublishDate+"','"+Price+"')";
		System.out.println(sql);
		flag  = controlDB.executeUpdate(sql);
		return flag;
	}
	//�������߲���
	public boolean addauthor(int AuthorID,String Name,int Age,String Country) throws Exception {
		boolean flag = true;
		String sql = "insert into Author values('"+AuthorID+"','"+Name+"','"+Age+"','"+Country+"')";
		System.out.println(sql);
		flag  = controlDB.executeUpdate(sql);
		return flag;
	}
	//ɾ������
	public boolean delete(String book) throws Exception {
		boolean flag = true;
		String sql = "delete from Book where Title = \"" + book + "\"";
		System.out.println(sql);
		flag  = controlDB.executeUpdate(sql);
		return flag;
	}
	//ȫ����ѯ
	public List<Book> getAll() throws Exception {
		String sql = "select * from Book";
		List<Book> list = controlDB.executeQueryBook(sql);
		return list;
	}
	//���������ֲ���
	public Book getByName(String bookname) throws Exception {
		String sql = "select * from Book where Title = \"" + bookname + "\"";
		List<Book> list = controlDB.executeQueryBook(sql);
		return list.get(0);
	}
	//�����߲�ѯ��
	public Book getByNameforbook(Author au) throws Exception {
		String sql = "select * from Book where Name = \"" + au.getName() + "\"";
		List<Book> list = controlDB.executeQueryBook(sql);
		return list.get(0);
	}
	//���������ֲ�����
	public Author getByAuthorNameforauthor(String authorname) throws Exception {
		String sql = "select * from Author where Name = \"" + authorname + "\"";
		List<Author> list = controlDB.executeQueryAuthor(sql);
		if(list.size()==0) return null;
		else return list.get(0);
	}
	//������ID������
	public Author getByAuthorIDforauthor(int authorid) throws Exception {
		String sql = "select * from Author where AuthorID = \"" + authorid + "\"";
		List<Author> list = controlDB.executeQueryAuthor(sql);
		if(list.size()==0)	{
			System.out.println("yse");
			return null;
		}
		else return list.get(0);
	}
	//������ID����
	public List<Book> getAuthorIDforBook(int authorid) throws Exception {
		String sql = "select * from Book where AuthorId = \"" + authorid + "\"";
		List<Book> list = controlDB.executeQueryBook(sql);
		return list;
	}
}
