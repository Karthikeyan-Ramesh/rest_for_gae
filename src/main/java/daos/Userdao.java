package daos;

import org.json.JSONObject;
import objects.User;

public interface Userdao {

	JSONObject createUser(User User);
	
	JSONObject deleteUser(Long UserId);

}
