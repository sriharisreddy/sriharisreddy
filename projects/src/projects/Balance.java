package projects;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Balance() {
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
	       HttpSession session=request.getSession();
	        String acc_no=(String)session.getAttribute("acc_no");
	        System.out.println(acc_no);
	        Model m=new Model();
	        m.setAcc_no(acc_no);
	        
	        boolean status=m.checkBalance();
	        int balance=m.getBalance();
	        
	        if(status)
	        {
	        	session=request.getSession(true);
	      	  session.setAttribute("balance",balance);
	      	  response.sendRedirect("/projects/CheckBalanceSuccess.jsp");
	        }
	        else
	        {
	      	  response.sendRedirect("/projects/Failure.html");
	        }
	}

}
