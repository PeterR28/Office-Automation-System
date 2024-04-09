public  class Patient extends Actor
{
	
	String[] patientInfo  = new String[5] ;
	String medicalHistory;
	int id; 
	Role role; 
	public Patient ()
	{
		this.role = Role.PATIENT;
		id = 12345;
		this.patientInfo[0] = "Name ";
		this.patientInfo[1] = "Date of Birth ";
		this.patientInfo[2] = "Phone Number";
		this.patientInfo[3] = "Insurance ID";
		this.patientInfo[4] = "CVS pahrmacy"; 
		
		this.medicalHistory = "i am ok ";
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
	public String getMedicalHistory()
	{
		return medicalHistory;
	}
	public Role getRole()
	{
		return role;
	}

