package yy.user;

public class UserAction {
	private String username;
	private String password;	 
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public String execute() throws Exception {		
		if(username.equals("yy")&&password.equals("123")){
			String aaa = "222ddd"; 
			return "success";
		}else{
			return "error";
		}
	}
}
