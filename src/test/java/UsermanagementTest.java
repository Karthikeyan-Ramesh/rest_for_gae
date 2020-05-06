
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONExce
ption;
import org.json.JSONObject;

import action.Usermanagement;

public class UsermanagementTest {

	
	 private Usermanagement usermng;
	 @Mock
	 HttpServletRequest request;
	 MockHttpServletResponse response;
	 
	@Before 
	public void setup() { usermng = new Usermanagement(); }
	 
	@Before
	  public void setUp() throws Exception {
		  MockitoAnnotations.initMocks(this);
		  when(request.getRequestURI()).thenReturn("http://local/user/34534534");
	  }

	@Test
	public void test() throws Exception {
	
		JSONObject jb = new JSONObject();
		try {
			jb.put("name", "karthikeyan");
			jb.put("email", "ka@gmail.com");
			jb.put("mobile", "8825461535");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	when(request.getReader()).thenReturn(new BufferedReader(new StringReader(jb.toString())));
	when(request.getContentType()).thenReturn("application/json");
	response = new MockHttpServletResponse();
	usermng.doPost(request, response);
	Assert.assertEquals("text/plain", response.getContentType());
	Assert.assertEquals("success", response.getWriterContent().toString());
	}

	@Test
	public void namevalidation() {
		
		JSONObject jb = new JSONObject();
		try {
			jb.put("name", "karthikeyan");
			jb.put("email", "ka@gmail.com");
			jb.put("mobile", "8825461535");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String result = usermng.createuser(jb.toString(),"name",1);
		 Assert.assertEquals("name is in correct format",result);
	}
	
	@Test
	public void emailvalidation() {
		
		JSONObject jb = new JSONObject();
		try {
			jb.put("name", "karthikeyan");
			jb.put("email", "ka@gmail.com");
			jb.put("mobile", "8825461535");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String result = usermng.createuser(jb.toString(),"email",1);
		 Assert.assertEquals("email is in correct format",result);
	}
	
	@Test
	public void mandatoryvalidation() {
		
		JSONObject jb = new JSONObject();
		try {
			jb.put("name", "karthikeyan");
			jb.put("email", "ka@gmail.com");
			jb.put("mobile", "8825461535");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String result = usermng.createuser(jb.toString(),"",0);
		 Assert.assertEquals("success",result);
	}

}
