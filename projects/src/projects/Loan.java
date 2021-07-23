package projects;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loan
 */
public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loan() {
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
		int pamt=Integer.parseInt(request.getParameter("pamt"));
		int time=Integer.parseInt(request.getParameter("time"));
		double rate =10.5;
		
		double SI=(pamt*time*rate)/100;
		
		HttpSession session = request.getSession();
		session.setAttribute("pamt", pamt);
		session.setAttribute("time", time);
		session.setAttribute("rate", rate);
		session.setAttribute("SI", SI);
		response.sendRedirect("/projects/LoanSuccess.jsp");	
		
	}

}
