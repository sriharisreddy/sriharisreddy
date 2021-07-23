package projects;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String custid=request.getParameter("custid");
		String password=request.getParameter("password");
		
		Model m=new Model();
		m.setCustid(custid);
		m.setPassword(password);
		
		boolean status = m.Login();
		String Acc_no = m.getAcc_no();
		System.out.println(Acc_no);
		if(status)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("acc_no",Acc_no);
			
			response.sendRedirect("/projects/Success.html");
		}
		else
		{
			response.sendRedirect("/projects/Failure.html");
		}
	}

}
