import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ReponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
public Reponse reponse = new Reponse();

  protected void doGet(HttpServletRequest request, HttpServletResponse respense) throws IOException, ServletException {

	  String spageid=request.getParameter("p");
	  int p=Integer.parseInt(spageid);
	  
    reponse.chargement();
    reponse.affichageHTML();
    
    
    
    
    if(p==1) {
    	String S1= request.getParameter("Q1");
	    String S2= request.getParameter("Q2");
	    String S3= request.getParameter("Q3");
	    int I1=Integer.parseInt(S1); 
	    int I2=Integer.parseInt(S2); 
	    int I3=Integer.parseInt(S3);
    	reponse.affi2(I1,I2,I3);
    }
    else if(p==2)
    {
    	String S1= request.getParameter("Q1");
	    String S2= request.getParameter("Q2");
	    int I1=Integer.parseInt(S1); 
	    int I2=Integer.parseInt(S2);
    	reponse.affi3(I1,I2);
    }
    	
    String string = reponse.getHtmlStrings();
    //String r1 = ("Q1");
    
    
    request.setAttribute("reponse_string", string);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/reponse.jsp");
    dispatcher.forward(request, respense);

  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
