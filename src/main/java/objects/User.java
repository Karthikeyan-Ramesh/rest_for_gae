package objects;


public class User {

	private long id;
	private String name;
	private String email;
	private String mobile;
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";
	
	private User(Builder builder) {
		
		this.id = builder.id;
		this.name = builder.name;
		this.email = builder.email;
		this.mobile = builder.mobile;
		
	}
	
	public static class Builder {
		
		private long id;
		private String name;
		private String email;
		private String mobile;
		
		public Builder id(long id) {
		  this.id = id;
		  return this;
	    }

		public Builder name(String name) {
			  this.name = name;
			  return this;
		    }
		
		public Builder email(String email) {
			  this.email = email;
			  return this;
		    }
		
		public Builder mobile(String mobile) {
			  this.mobile = mobile;
			  return this;
		    }
	    public User build() {
	      return new User(this);
	    }
		
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
		
}
