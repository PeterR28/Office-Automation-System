 enum Role 
  {
    DOCTOR, 
    NURSE, 
    PATIENT,
  }
public interface Actor
{
  Role role;
 void sendMessage(String message);
 void editPatientInfo(String PatientId);
 void accesssMedicalHIstory(String patientId);
 void scheduleAppoitment(int patientID, String data);
}
