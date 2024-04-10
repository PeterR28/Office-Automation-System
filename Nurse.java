public class Nurse extends Actor
{
	public Nurse()
	{
		this.role = Role.NURSE;
	}
	
	public Nurse(String user, String pass)
	{
		this.role = Role.NURSE;
		
		this.username = user;
		this.password = pass;
	}
	
	public void saveVitals(String PatientId, String vitals)
	{
		
	}
}
