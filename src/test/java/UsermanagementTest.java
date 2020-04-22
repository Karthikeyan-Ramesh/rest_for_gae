
import org.junit.Before;
import org.junit.Test;

import action.Usermanagement;

public class UsermanagementTest {

	private Usermanagement usermng;
	
	@Before 
	public void setup() { 
		MockHttpServletResponse response = new MockHttpServletResponse();
		usermng = new Usermanagement(); 
	}
	
	@Test
	public void testdoPost() {

		
	}

}
