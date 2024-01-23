

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		pw.print("<h1>Hello Everyone..</h1>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
	
	String uname = request.getParameter("uname");
	String password = request.getParameter("pass");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	System.out.println(uname+" "+password+" "+email+" "+phone);
	
	Member member = new Member (uname, password, email, phone);
	
	RegisterDao rDao = new RegisterDao();
	String result = rDao.insert(member);
	//rDao.insert(member);
	try {
		response.getWriter().print(result);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
