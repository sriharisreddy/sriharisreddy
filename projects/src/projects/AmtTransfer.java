package projects;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AmtTransfer
 */
public class AmtTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmtTransfer() {
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
		try
		{
	        int tamt=Integer.parseInt(request.getParameter("tamt"));
	        String tacc_no=request.getParameter("tacc_no");
	        HttpSession session=request.getSession();
	        String acc_no=(String)session.getAttribute("acc_no");
	        Model m=new Model();
	        m.setAcc_no(acc_no);
			m.setTacc_no(tacc_no);
	        m.setTamt(tamt);
	        
	        boolean status=m.AmtTransfer();
	        
	        if(status)
	        {
	      	  response.sendRedirect("/projects/TransferSuccess.html");
	        }
	        else
	        {
	      	  response.sendRedirect("/projects/TransferFailure.html");
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
	}


