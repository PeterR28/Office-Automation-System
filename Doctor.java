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

	public Role getRole()
	{
		return role;
	}
}
