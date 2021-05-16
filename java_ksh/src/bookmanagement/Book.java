package bookmanagement;

public class Book {

	private String title;
	private String writer;
	private String translator;
	private String publisher;
	private int isbn;
	private int pages;
	private String genre;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Book(String title, String writer, String translator, String publisher, int isbn, int pages, String genre) {
		this.title = title;
		this.writer = writer;
		this.translator = translator;
		this.publisher = publisher;
		this.isbn = isbn;
		this.pages = pages;
		this.genre = genre;
	}
	
	public void update(String title, String writer, String translator, String publisher, int isbn, int pages, String genre) {
		if(title != null)
			this.title = title;
		if(writer != null)
			this.writer = writer;
		if(translator != null)
			this.translator = translator;
		if(publisher != null)
			this.publisher = publisher;
		if(isbn != 0)
			this.isbn = isbn;
		if(pages != 0)
			this.pages = pages;
		if(genre != null)
			this.genre = genre;
	}
	
}
