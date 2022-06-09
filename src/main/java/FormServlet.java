import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
public Formulaire formulaire = new Formulaire();

  protected void doGet(HttpServletRequest request, HttpServletResponse respense) throws IOException, ServletException {

    formulaire.chargement();
    formulaire.affichageHTML();
    String string = formulaire.getHtmlStrings();
    request.setAttribute("formulaire_string", string);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
    dispatcher.forward(request, respense);

  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
