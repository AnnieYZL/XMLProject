package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import dao.BookDao;
import dao.dangnhapdao;
import dao.giohangdao;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
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
			dangnhapdao dndao = new dangnhapdao();
			String usname = request.getParameter("usname");
			String pass = request.getParameter("pass");
			HttpSession session = request.getSession();
			if(session.getAttribute("bdn")==null){
				int bdn = 0;
				session.setAttribute("bdn", bdn);
			}
			if(usname!=null&&pass!=null){
				Users nd = dndao.getNgdung(usname, pass);
				if(usname.equals("admin")&&pass.equals("123")) {
					session.setAttribute("admin", 1);
					response.sendRedirect("menuController");
					return;
				}
				else if(nd!=null){
					session.setAttribute("nd", nd);
					giohangdao gh = new giohangdao();
					session.setAttribute("gh", gh);
					response.sendRedirect("menuController");
					return;
				}
				else{
					request.setAttribute("kt", "Đã nhập sai thông tin!");
					int bdn= (int)session.getAttribute("bdn");
					bdn++;
					session.setAttribute("bdn", bdn);
					if(bdn>=3)
						response.sendRedirect("captchaController");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
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
