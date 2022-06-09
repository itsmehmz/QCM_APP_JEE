import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Question extends QCM {
		
		
		List<Quest> Question = new ArrayList<Quest>();
		public String htmlStrings;
		public String htmlStr;

	  
	public void chargement() {
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	    
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager.getConnection("jdbc:mysql://localhost/dbqcm", "root", "");
	      // step 3 : create a SQL statement
	      statement = connection.createStatement();
	      // step 4 : execute SQL query
	      resultSet = statement.executeQuery("SELECT * FROM question");
	      // step 5 : process the result set
	      while (resultSet.next()) {
              int id = resultSet.getInt(1);
              String lib = resultSet.getString(2);
              
              Quest quest=new Quest();
              quest.setLib(lib);
              quest.setId_F(id);
              
              Question.add(quest);
          }

	    } catch (Exception exc) {
	      // TODO: handle exception
	      exc.printStackTrace();
	    }
	  }

	  public void affichageHTML() {
		htmlStrings = "<div align=\"center\">";
		htmlStrings += "<fieldset style=\"border: 3px solid green; width:500px;\">";
		htmlStrings += "<h1>Question</h1>";
		htmlStrings += "<fieldset style=\"border: 4px solid black\">";
	    htmlStrings += "<ul>";
	    htmlStrings += "<form action=\"reponse.jsp?p=1\" method=\"post\">";
	    for (Quest Q : Question) {
	    	if(Q.getId_F()==1) {
	    	htmlStrings += Q.getLib();
	    	htmlStrings += ": <br>";
	    	htmlStrings += "<li><input type=\"radio\" name=\"Q1\" value=\"1\" />Vrai</li>";
	    	htmlStrings += "<li><input type=\"radio\" name=\"Q1\"value=\"0\"/>Faux</li>";
	    	//htmlStrings += "<br>";
	    	}
	    	if(Q.getId_F()==2) {
		    	htmlStrings += Q.getLib();
		    	htmlStrings += ": <br>";
		    	htmlStrings += "<li><input type=\"radio\" name=\"Q2\" value=\"1\" />Vrai</li>";
		    	htmlStrings += "<li><input type=\"radio\" name=\"Q2\"value=\"0\"/>Faux<br/></li>";
		    	htmlStrings += "<br>";
		    	
		    	}
	    	if(Q.getId_F()==3) {
		    	htmlStrings += Q.getLib();
		    	htmlStrings += ": <br>";
		    	htmlStrings += "<li><input type=\"radio\" name=\"Q3\" value=\"0\" />de stocker des entiers de -32768 à 32767</li>";
		    	htmlStrings += "<li><input type=\"radio\" name=\"Q3\"value=\"1\"/>de stocker des entiers de 0 à 65535</li>";
		    	htmlStrings += "<li><input type=\"radio\" name=\"Q3\" value=\"0\"/>de stocker des entiers de 0 à 255</li>";
		    	htmlStrings += "<br>";
		    	
		    	}
	    		
	   }
	    
	    htmlStrings += "<input type=\"submit\">";
    	htmlStrings += "</form>";
	    htmlStrings += "</ul>";
	    htmlStrings += "</fieldset>";
	    htmlStrings += "</fieldset>";
	    htmlStrings += "</div>";
	    
	    
	  };
	  public void Aff2() {
			htmlStr = "<div align=\"center\">";
			htmlStr += "<fieldset style=\"border: 3px solid green; width:500px;\">";
			htmlStr += "<h1>Questions</h1>";
			htmlStr += "<fieldset style=\"border: 4px solid black\">";
		    htmlStr += "<ul>";
		    htmlStr += "<form action=\"reponse.jsp?p=2\" method=\"post\">";
		    
		    for (Quest Q : Question) {
		    	if(Q.getId_F()==4) {
		    		htmlStr += Q.getLib();
			    	htmlStr += ": <br>";
			    	htmlStr += "<li><input type=\"radio\" name=\"Q4\" value=\"0\" />Le nombre de caractéres dans une chaine</li>";
			    	htmlStr += "<li><input type=\"radio\" name=\"Q4\"value=\"0\"/>Le nombre de méthode d'un objet</li>";
			    	htmlStr += "<li><input type=\"radio\" name=\"Q4\" value=\"1\"/>Le nombre de d'élément d'un tableau</li>";
			    	htmlStr += "<br>";
		    	
		    	}
		    	if(Q.getId_F()==5) {
		    		htmlStr += Q.getLib();
			    	htmlStr += ": <br>";
			    	htmlStr += "<li><input type=\"radio\" name=\"Q5\" value=\"0\" />Poeple Home Pearl</li>";
			    	htmlStr += "<li><input type=\"radio\" name=\"Q5\"value=\"1\"/>PHP Hypertext Preprocessor</li>";
			    	htmlStr += "<li><input type=\"radio\" name=\"Q5\" value=\"0\"/>Personnal home page</li>";
			    	htmlStr += "<br>";
		    	
		    	}
		    }
		    htmlStr += "<input type=\"submit\">";
		    htmlStr += "</form>";
		    htmlStr += "</ul>";
		    htmlStr += "</fieldset>";
		    htmlStr += "</fieldset>";
		    htmlStr += "</div>";
		  
	  }

	  public String getHtmlStrings() {
	    return htmlStrings;
	  }
	  public String getHtmlStr() {
			return htmlStr;
		}
}
