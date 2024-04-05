package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dangkydao;
import dao.dangnhapdao;


/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
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
			dangkydao dkdao = new dangkydao();
			dangnhapdao dndao = new dangnhapdao();
			String hoten = request.getParameter("ht");
			String tennguoidung = request.getParameter("tdn");
			String matkhau= request.getParameter("mk");
			String tb = null;
			if(hoten!=null&&tennguoidung!=null&&matkhau!=null) {
				if(dkdao.KtDangKy(tennguoidung)!=0) {
					dkdao.dangKy(dndao.getMaxMaND()+1,hoten, tennguoidung, matkhau);
					tb = "Đăng ký thành công!";
					request.setAttribute("tb", tb);
				}
				else {
					tb = "Tên đăng nhập đã tồn tại!";
					request.setAttribute("tb", tb);
				}	
			}
			RequestDispatcher rd = request.getRequestDispatcher("dangky.jsp");
			rd.forward(request, response);
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
