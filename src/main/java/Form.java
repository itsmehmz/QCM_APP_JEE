import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Form extends Quiz {
  private String[] formulaires = new String[2];
  public String htmlStrings;

  public void chargement() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost/dbquiz", "root", "");
      // step 3 : create a SQL statements
      String sql = "select lib_formulaire from formulaire";
      statement = connection.createStatement();

      // step 4 : execute SQL query
      resultSet = statement.executeQuery(sql);

      // step 5 : data save
      int i = 0;
      while (resultSet.next()) {
        String libForm = resultSet.getString("lib_formulaire");
        formulaires[i] = libForm;
        i++;
      }

    } catch (Exception exc) {
      // TODO: handle exception
      exc.printStackTrace();
    }
  }

  public void affichageHTML() {
	htmlStrings = "<div align=\"center\">";
	htmlStrings += "<fieldset style=\"border: 3px solid green; width:500px;\">";
	htmlStrings += "<h1>Liste des QCM</h1>";
	htmlStrings += "<fieldset style=\"border: 4px solid black\">";
    htmlStrings += "<ul>";
    htmlStrings += "<form method=\"post\" action=\"reponse.jsp\" scope=\"request\">";
    for (String string : formulaires) {
      if (string.toLowerCase().contains("mysql")) {
        htmlStrings += "<li><a  href='/Quiz/question.jsp?page=1'>" + string + "</a></li>";
       // htmlStrings += "<jsp:param name=\"mysql\" value=\"1\"/>";
      }
      else {
        htmlStrings += "<li><a  href='/Quiz/question.jsp?page=2'>" + string + "</a></li>";
        //htmlStrings += "<jsp:param name=\"php\" value=\"2\"/>";
      }
    }
    htmlStrings += "</form>";
    htmlStrings += "</ul>";
    htmlStrings += "</fieldset>";
    htmlStrings += "</fieldset>";
    htmlStrings += "</div>";
    
    
  };

  public String getHtmlStrings() {
    return htmlStrings;
  }
}
