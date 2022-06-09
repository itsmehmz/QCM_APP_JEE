import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
	
	
public class Reponse extends QCM {
		
		
		List<Rep> Reponse = new ArrayList<Rep>();
		List<String> St = new ArrayList<String>();
		public String htmlStrings;
		public int score = 0;
		public void addString(String s) {
			St.add(s);
		}
	  public void chargement() {
		    Connection connection = null;
		    Statement statement = null;
		    ResultSet resultSet = null;
		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      connection = DriverManager.getConnection("jdbc:mysql://localhost/dbqcm", "root", "");
		      // step 3 : create a SQL statements
		      String sql = "SELECT * FROM reponse;";
		      statement = connection.createStatement();

		      // step 4 : execute SQL query
		      resultSet = statement.executeQuery(sql);

		      // step 5 : process the result set
		      
		      while (resultSet.next()) {
	                int id1 = resultSet.getInt(1);
	                int id2 = resultSet.getInt(2);
	                String lib = resultSet.getString(3);
	                int c = resultSet.getInt(4);
	                
	                Rep r= new Rep();
	                r.setId1(id1);
	                r.setId1(id2);
	                r.setLib(lib);
	                r.setC(c);
	                
	                Reponse.add(r);
	            }
		    } catch (Exception exc) {
		      // TODO: handle exception
		      exc.printStackTrace();
		    }
		  }
	  
	  public void affichageHTML() {
		  
		htmlStrings = "<div align=\"center\">";
		htmlStrings += "<fieldset style=\"border: 3px solid green; width:500px;\">";
		htmlStrings += "<h1>Resultats</h1>";
		htmlStrings += "<fieldset style=\"border: 4px solid black\">";
	    htmlStrings += "";
	    	
	    
	    
	    
	    
	  };
	  public void affi2(int i1,int i2,int i3) {
		    	if(i1==1) score++;
		    	if(i2==1) score++;
		    	if(i3==1) score++;
		    	
		  htmlStrings += "<p>Votre Score est :</p>";
		  htmlStrings += "<p>"+score+"/3</p>";
		  score = 0;
		    htmlStrings += "</fieldset>";
		    htmlStrings += "</fieldset>";
		    htmlStrings += "</div>";
		    
	  }
	  public void affi3(int i1,int i2) {
	    	if(i1==1) score++;
	    	if(i2==1) score++;
	    	
	    	
	  htmlStrings += "<p>Votre Score est :</p>";
	  htmlStrings += "<p>"+score+"/3</p>";
	    htmlStrings += "</fieldset>";
	    htmlStrings += "</fieldset>";
	    htmlStrings += "</div>";
	    
}

	  public List<Rep> getReponse() {
		return Reponse;
	}
	public void setReponse(List<Rep> reponse) {
		Reponse = reponse;
	}
	public String getHtmlStrings() {
	    return htmlStrings;
	  }
	
}
