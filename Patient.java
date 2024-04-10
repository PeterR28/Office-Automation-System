import java.util.Random;

public  class Patient extends Actor
{
	
	String[] patientInfo  = new String[5] ;
	String []medicalHistory = new String[5];
	String appointmentDate; 
	int id; 
	Role role; 
	public Patient ()
	{
		this.role = Role.PATIENT;
		Random randomObj = new Random();
		//creates a random number 
		 id = 10000 + randomObj.nextInt(90000); // 90000 is the range size
		    
		this.patientInfo[0] = "Name ";
		this.patientInfo[1] = "Date of Birth ";
		this.patientInfo[2] = "Phone Number";
		this.patientInfo[3] = "Insurance ID";
		this.patientInfo[4] = "CVS pahrmacy"; 
		this.medicalHistory[0] = "previous visits";
		this.medicalHistory[1] = "previous health issues";
		this.medicalHistory[2] = "previous medications";
		this.medicalHistory[3] = "history of immunization";
	}
	
	public void sendMessage(String message)
	{
		super.sendMessage(message);
	}
	public int getId()
	{
		return id;
	}
	public String[] getContactInfo()
	{
		return patientInfo;
		
	}
	public void setMedicalHIstory(String [] history)
	{
		medicalHistory = history; 
	}
	public String[] getMedicalHistory()
	{
		return medicalHistory;
	}
	public Role getRole()
	{
		return role;
	}

}

