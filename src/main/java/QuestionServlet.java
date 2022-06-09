import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Question question = new Question();
 
  protected void doGet(HttpServletRequest request, HttpServletResponse respense) throws IOException, ServletException {
	String spageid=request.getParameter("page");
	int pageid=Integer.parseInt(spageid); 
    question.chargement();
    if(pageid == 1) {
    question.affichageHTML();
    String string = question.getHtmlStrings();
    request.setAttribute("question_string", string);
    }
    else if(pageid == 2) {
    	question.Aff2();
    	String string = question.getHtmlStr();
        request.setAttribute("question_string", string);
    }
    
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/question.jsp");
    dispatcher.forward(request, respense);

  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
