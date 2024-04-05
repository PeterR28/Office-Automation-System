
public class Office {
	
	public Office() {
		// FIXME: make constructor
		// on startup, the office has to load all of the usernames and passwords
		// into a Map. (Probably a map?? maybe a hashmap. I need to figure out
		// how to hash things so I'm not storing raw passwords)
	}
	
	// all of these guys can be done relatively similarly to HW4.
	public void storePatientInfo(int patientID, String info) {
		//FIXME: make storePatientInfo
	}
	
	public void storeMedicalHistory(int patientID, String history) {
		//FIXME: make storeMedicalHistory
	}
	
	public void storeAccount(String username, String password, Enum role) {
		//FIXME: make storeAccount
	}
	
	public void storeMessages(int patientID, String messages) {
		//FIXME: make storeMessages
	}
	
	// all of these guys can be done relatively easy in the same way as HW4.
	public String getPatientInfo(int patientID) {
		//FIXME: make getPatientInfo()
		return "getPatientInfo() isn't working";
	}
	
	public String getMedicalHistory(int patientID) {
		//FIXME: make getMedicalHistory()
		return "getMedicalHistory() isn't working";
	}
	
	public String getMessages(int patientID) {
		//FIXME: make getMessages()
		return "getMessages() isn't working";
	}
	
	// thoughts about this guy: taking in a patientID isn't gonna help for accounts that aren't
	// patients. Instead, take in a username, password, and compare it to the actor object.
	// We could also include an ID for every type of user as well. Something to think about.
	public String getAccountInfo(String username, String password, Actor a) {
		//FIXME: make getAccountInfo()
		return "getAccountInfo() isn't working";
	}
}