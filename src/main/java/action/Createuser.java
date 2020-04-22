package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import daos.Datastoredao;
import daos.Userdao;
import objects.User;

@SuppressWarnings("serial")
public class Createuser extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
	    Userdao dao = new Datastoredao();
	    this.getServletContext().setAttribute("dao", dao);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		     jb.append(line);
		  } catch (Exception e) { }

		  try {
		    JSONObject jsonObject = new JSONObject(jb.toString());
		    User user = new User.Builder()
			        .name(jsonObject.getString("name"))   
			        .email(jsonObject.getString("email"))
			        .mobile(jsonObject.getString("mobile"))
			        .build();
		    
		    Userdao dao = (Userdao) this.getServletContext().getAttribute("dao");
		    
		    try {
		    	JSONObject result = dao.createUser(user);
				response.setContentType("application/json");
				response.getWriter().println(result);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    
		  } catch (JSONException e) {
		    throw new IOException("Error parsing JSON request string");
		  }

	}
	
	@Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print(true);
		/*
		 * Long id = Long.decode(req.getParameter("id")); Userdao dao = (Userdao)
		 * this.getServletContext().getAttribute("dao"); try { JSONObject result =
		 * dao.deleteUser(id); response.setContentType("application/json");
		 * response.getWriter().println(result); } catch (Exception e) { throw new
		 * ServletException("Error deleting User", e); }
		 */
	}


}
