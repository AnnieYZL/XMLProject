package bean;

public class Users {
	private int maKhach;
	private String hoTen;
	private String username;
	private String password;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int maKhach, String hoTen, String username, String password) {
		super();
		this.maKhach = maKhach;
		this.hoTen = hoTen;
		this.username = username;
		this.password = password;
	}
	public int getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(int maKhach) {
		this.maKhach = maKhach;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [maKhach=" + maKhach + ", hoTen=" + hoTen + ", username=" + username + ", password=" + password
				+ "]";
	}
	
}
