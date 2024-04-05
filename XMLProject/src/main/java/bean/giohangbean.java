package bean;

import java.util.ArrayList;

public class giohangbean {
	private long id;
	private String title;
	private ArrayList<String> author;
	private int year;
	private double price;
	private String image;
	private int soluong;
	private double thanhtien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(long id, String title, ArrayList<String> author, int year, double price, String image,
			int soluong) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.image = image;
		this.soluong = soluong;
		this.thanhtien = this.soluong*this.price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<String> getAuthor() {
		return author;
	}
	public void setAuthor(ArrayList<String> author) {
		this.author = author;
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
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getThanhtien() {
		return soluong*price;
	}
	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
}
