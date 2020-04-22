package daos;

import java.sql.SQLException;

import org.json.JSONObject;

import objects.User;

public interface Userdao {

	JSONObject createUser(User User) throws SQLException;
	
	JSONObject deleteUser(Long UserId) throws SQLException;

}
