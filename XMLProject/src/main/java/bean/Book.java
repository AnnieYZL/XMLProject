package bean;

import java.util.ArrayList;

public class Book {
	private long id;
	private String category;
	private String title;
	private String lang;
	private ArrayList<String> author;
	private String cover;
	private int year;
	private double price;
	private String image;
	public Book() {
		super();
	}
	public Book(long id, String category, String title, String lang, ArrayList<String> author, String cover, int year,
			double price, String image) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.lang = lang;
		this.author = author;
		this.cover = cover;
		this.year = year;
		this.price = price;
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public ArrayList<String> getAuthor() {
		return author;
	}
	public void setAuthor(ArrayList<String> author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", category=" + category + ", title=" + title + ", lang=" + lang + ", author="
				+ author + ", cover=" + cover + ", year=" + year + ", price=" + price + ", image=" + image + "]" + "\n";
	}
	
	
	
}
