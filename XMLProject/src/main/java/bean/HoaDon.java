package bean;

import java.util.Date;

public class HoaDon {
	private long maHoaDon;
	private long maKhach;
	private Date ngayMua;
	private long id;
	private int soLuong;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(long maHoaDon, long maKhach, Date ngayMua, long id, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhach = maKhach;
		this.ngayMua = ngayMua;
		this.id = id;
		this.soLuong = soLuong;
	}
	public long getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public long getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(long maKhach) {
		this.maKhach = maKhach;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maKhach=" + maKhach + ", ngayMua=" + ngayMua + ", id=" + id
				+ ", soLuong=" + soLuong + "]";
	}
	
}
