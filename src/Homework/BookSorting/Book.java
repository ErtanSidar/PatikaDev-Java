package Homework.BookSorting;

import java.util.Date;

public class Book {
	private String bookName;
	private int pageSize;
	private String authorName;
	private Date publishedDate;
	
	public Book(String bookName, int pageSize, String authorName, Date publishedDate) {
		super();
		this.bookName = bookName;
		this.pageSize = pageSize;
		this.authorName = authorName;
		this.publishedDate = publishedDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	

}
