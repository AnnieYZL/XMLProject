package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.HoaDon;
import bean.Users;
import dao.BookDao;
import dao.giohangdao;
import dao.hoadondao;

/**
 * Servlet implementation class hoadonController
 */
@WebServlet("/hoadonController")
public class hoadonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoadonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			Users nd = (Users)session.getAttribute("nd");
			long makh = nd.getMaKhach();
			hoadondao hddao = new hoadondao();
			ArrayList<HoaDon> dshd = hddao.getLichsu(makh);
			request.setAttribute("dshd", dshd);
			RequestDispatcher rd = request.getRequestDispatcher("hoadon.jsp");
			rd.forward(request, response);
//			if(thanhtoan!=null) {
//				int t = Integer.parseInt(thanhtoan);
//				if(t==1) {
//					String kqtt = null;
//					hoadonbo hdbo = new hoadonbo();
//					khachhangbean kh = (khachhangbean)session.getAttribute("dn");
//					long makh = kh.getMakh();
//					hdbo.ThemHoaDon(makh);
//					long mahd = hdbo.getMaxHD();
//					chitietbo ctbo = new chitietbo();
//					for(giohangbean h : gh.ds){
//						ctbo.Them(h.getMasach(), h.getSoluongmua(), mahd);
//					}
//					session.removeAttribute("gh");
//					request.setAttribute("kqtt", "Da thanh toan thanh cong!");
//					response.sendRedirect("htgiohang.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
