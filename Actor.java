import java.io.IOException;

public class Actor
{
	public enum Role 
	 {
		DOCTOR, 
	    NURSE, 
	    PATIENT,
	}
 protected Role role;
 
 public  void sendMessage(String message)
 {
	 
 }
 
 //public abstract void editPatientInfo(String PatientId, String updatedInfo)
 //{
	 //access record based on PatiendID
	// Office.getInstance().
	 //add the string updatedInfo to the record 
	 //write to file 
	 //read it 
 //}
 //to update patient info you should search through the textfiles that should be saved in your Eclipse workspace
 //and then find the file that starts with the patient ID, and write to that file with the new patient Information.
 public void accesssMedicalHIstory(int patientId)
 {
	 try {
		Office.getInstance().getMedicalHistory(patientId);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 //to accessMedicalHiostry you should search through the file system and find the file that starts with the patient ID 
 public void scheduleAppoitment(int patientID, String date)
 {
	 
 }
 
}
