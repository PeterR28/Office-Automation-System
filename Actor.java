public interface Actor
{
 enum Role 
  {
    DOCTOR, 
    NURSE, 
    PATIENT,
  }
 void sendMessage(String message);
 void editPatientInfo(String PatientId);
 void accesssMedicalHIstory(String patientId);
 void scheduleAppoitment(int patientID, String data);
}
