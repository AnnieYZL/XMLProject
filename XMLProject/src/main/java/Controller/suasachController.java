package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;

/**
 * Servlet implementation class suasachController
 */
@WebServlet("/suasachController")
public class suasachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suasachController() {
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
			BookDao bdao = new BookDao();
			String masach = request.getParameter("masach");
			if(masach!=null) {
				Book sach = bdao.inSach(Long.parseLong(masach)); 
			request.setAttribute("sach", bdao.inSach(Long.parseLong(masach)));
			}
			String title = request.getParameter("title");
			String category = request.getParameter("category");
			String cover = request.getParameter("cover");
			String lang = request.getParameter("lang");
			String a0 = request.getParameter("a0");
			String a1 = request.getParameter("a1");
			String a2 = request.getParameter("a2");
			String a3 = request.getParameter("a3");
			String a4 = request.getParameter("a4");
			String year = request.getParameter("year");
			String price = request.getParameter("price");
			String image = request.getParameter("image");
			String sua = request.getParameter("sua");
			String maxoa = request.getParameter("maxoa");
			if(sua!=null) {
				ArrayList<String> dstg = new ArrayList<String>();
				if(a0!=null) dstg.add(a0); if(a1!=null) dstg.add(a1); if(a2!=null) dstg.add(a2);
				if(a3!=null) dstg.add(a3); if(a4!=null) dstg.add(a4);
				bdao.suaSach(Long.parseLong(masach), category, cover, title, lang, dstg, Integer.parseInt(year), Double.parseDouble(price), image);
				request.setAttribute("ktcn", "Đã Cập nhật thành công!");
			}
			else if(maxoa!=null) {
				bdao.xoaSach(Long.parseLong(maxoa));
				response.sendRedirect("menuController");
			}
			RequestDispatcher rd = request.getRequestDispatcher("suasach.jsp");
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
