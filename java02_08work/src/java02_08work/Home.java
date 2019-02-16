package java02_08work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
*
* @author LiuXu
* @time2018年7月9日下午8:33:31
**/
public class Home extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		PrintWriter pw = res.getWriter();
		if (flag.equals("save")) {
			HttpSession session = req.getSession(true);
			String code = (String) session.getAttribute("code");
			pw.println("welcome"+code);
		}
		
		
		
	}
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
}
	
}
