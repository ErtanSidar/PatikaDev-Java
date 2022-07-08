package Homework.BookList;

import java.util.Date;

public class Book {
	private String name;
	private int page;
	private String authorName;
	private Date publishDate;
	
	public Book(String name, int page, String authorName, Date publishDate) {
		super();
		this.name = name;
		this.page = page;
		this.authorName = authorName;
		this.publishDate = publishDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
