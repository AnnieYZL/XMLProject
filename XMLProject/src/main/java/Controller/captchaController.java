package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

/**
 * Servlet implementation class captchaController
 */
@WebServlet("/captchaController")
public class captchaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public captchaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		request.setCharacterEncoding("UTF-8");
		String answer = request.getParameter("answer");
		String notice = null;
		if(answer==null) {
			response.sendRedirect("captcha.jsp");
		}
		else
		if (captcha.isCorrect(answer)) {	
		   session.removeAttribute("bdn");
		   response.sendRedirect("dangnhapController");
		} else {
			notice = "Captcha sai";
			request.setAttribute("notice", notice);
			RequestDispatcher rd = request.getRequestDispatcher("captcha.jsp");
			rd.forward(request, response);
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
