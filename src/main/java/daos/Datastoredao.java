package daos;


import org.json.JSONException;
import org.json.JSONObject;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import objects.User;

public class Datastoredao implements Userdao {

  private DatastoreService datastore;
  private static final String User_KIND = "UserManagement";

  public Datastoredao() {
    datastore = DatastoreServiceFactory.getDatastoreService();
  }

  public User entityToUser(Entity entity) {
    return new User.Builder()                       
        .name((String) entity.getProperty(User.NAME))
        .email((String) entity.getProperty(User.EMAIL))
        .id(entity.getKey().getId())
        .mobile((String) entity.getProperty(User.MOBILE))
        .build();
  }

  @SuppressWarnings("static-access")
  @Override
  public JSONObject createUser(User User) {
    Entity incUserEntity = new Entity(User_KIND); 
    incUserEntity.setProperty(User.NAME, User.getName());
    incUserEntity.setProperty(User.EMAIL, User.getEmail());
    incUserEntity.setProperty(User.MOBILE, User.getMobile());

    Key UserKey = datastore.put(incUserEntity);
    
    //Json object
    JSONObject jsonObject = new JSONObject();
    
    if(UserKey.getId()!=0) {
	    try {
			jsonObject.put("id", UserKey.getId());
			jsonObject.put("name", User.getName());
		    jsonObject.put("email", User.getEmail());
		    jsonObject.put("mobile", User.getMobile());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    
    }
    return jsonObject;                   
  }
  
  @Override
  public JSONObject deleteUser(Long UserId) {
    Key key = KeyFactory.createKey(User_KIND, UserId);        
    datastore.delete(key);   
    JSONObject jsonObject = new JSONObject();
     
    try {
		jsonObject.put("Success", "True");
	} catch (JSONException e) {
		e.printStackTrace();
	}
    return jsonObject;
  }

}

