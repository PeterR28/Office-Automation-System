public class Doctor extends Actor
{
	public Doctor()
	{
		this.role = Role.DOCTOR;
	}
	
	public Doctor(String user, String pass)
	{
		this.role = Role.DOCTOR;
		
		this.username = user;
		this.password = pass;
	}
	
	public String createNote()
	{
		return "Hello World";
	}
	
	public void saveNote(String note)
	{
		
	}

}
