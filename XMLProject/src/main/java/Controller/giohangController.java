package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import bean.giohangbean;
import dao.BookDao;
import dao.giohangdao;
import dao.hoadondao;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
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
			if(nd==null) {
				response.sendRedirect("dangnhapController");
			}
			else {
				BookDao bdao = new BookDao();
				String masach = request.getParameter("masach");
				String thanhtoan = request.getParameter("thanhtoan");
				giohangdao gh = null;
				if(session.getAttribute("gh")==null){
					gh = new giohangdao();
					session.setAttribute("gh", gh);
				}
				gh=(giohangdao)session.getAttribute("gh");
				if(masach!=null)		gh.Them(bdao.inSach(Long.parseLong(masach)), 1);
				session.setAttribute("gh", gh);
				
				int n = gh.ds.size();
				request.setAttribute("n", n);
				request.setAttribute("gh", gh);
				
				if(thanhtoan!=null) {
					if(nd!=null) {
						
					}
					int t = Integer.parseInt(thanhtoan);
					if(t==1) {
						String kqtt = null;
						hoadondao hddao = new hoadondao();
						
						long makh = nd.getMaKhach();
						Date ngaymua = new Date();
						
						for(giohangbean h : gh.ds){
							hddao.ThemHoaDon(hddao.getMaxHD()+1, makh, ngaymua, h.getId(),h.getSoluong() );
						}
						session.removeAttribute("gh");
						request.setAttribute("kqtt", "Đã thanh toán thành công!");
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
				rd.forward(request, response);
			}
			
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
