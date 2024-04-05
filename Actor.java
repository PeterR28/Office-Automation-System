 public enum Role 
  {
    DOCTOR, 
    NURSE, 
    PATIENT,
  }
public abstract class Actor
{
 protected Role role;
 public abstract void sendMessage(String message);
 public abstract void editPatientInfo(String PatientId, String updatedInfo);
 //to update patient info you should search through the textfiles that should be saved in your Eclipse workspace
 //and then find the file that starts with the patient ID, and write to that file with the new patient Information.
 public abstract void accesssMedicalHIstory(String patientId);
 //to accessMedicalHiostry you should search through the file system and find the file that starts with the patient ID 
 public abstract void scheduleAppoitment(int patientID, String date);
}
