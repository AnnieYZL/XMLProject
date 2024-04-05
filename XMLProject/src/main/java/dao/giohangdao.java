package dao;

import java.util.ArrayList;

import bean.Book;
import bean.giohangbean;

public class giohangdao {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(Book s, int soluongmua) {
		for(giohangbean h:ds) {
			if(h.getId()==s.getId()) {
				h.setSoluong(soluongmua+h.getSoluong());
				return;
			}
		}
		ds.add(new giohangbean(s.getId(), s.getTitle(), s.getAuthor(), s.getYear(), s.getPrice(), s.getImage(),	soluongmua));
	}
	public void Xoa(long masach) {
		for(giohangbean h:ds) {
			if(h.getId()==masach) {
				ds.remove(h);
				return;
			}
		}
	}
	public double TongTien() {
		double S=0;
		for(giohangbean h:ds) {
			S=S+h.getThanhtien();
		}
		return S;
	}
}
