import java.io.File;
import java.io.FileWriter;

public class Office {
	private final String FILEPATH = "src/records/";
	
	
	/*
	   	FIXME: make constructor
		on startup, the office has to load all of the usernames and passwords
		into a Map. (Probably a map?? maybe a hashmap. I need to figure out
		how to hash things so I'm not storing raw passwords)
		thoughts: try to see if I can have a Map with one key and multiple values (one for password, one for account type)
		if I can't do that, maybe append an extra digit to the end of the password to identify what type the account is
	 */
	
	public Office() {
		
	}
	
	// all of these guys can be done relatively similarly to HW4.
	public static void storePatientInfo(int patientID, String info) throws IOException {
		
		File log = new File(FILEPATH + patientID + "_info.txt");
		FileWriter writer = new FileWriter(FILEPATH + patientID + "_info.txt");
		log.createNewFile();
		writer.write(info);
		writer.close();
	}
	
	public static void storeMedicalHistory(int patientID, String history) throws IOException {
		
		File log = new File(FILEPATH + patientID + "_history.txt");
		FileWriter writer = new FileWriter(FILEPATH + patientID + "_history.txt");
		log.createNewFile();
		writer.write(history);
		writer.close();
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
	
	
	public static void main(String[] args) {
		
		storePatientInfo(12345, "test info");
	}
}