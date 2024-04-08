import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Office {
	
	private HashMap<String, String> accounts;
	private static Office officeInstance = null;
	private final String FILEPATH = "src/records/";
	
	/*
	 * Office is a singleton class. The constructor CANNOT be called. Instead, you have to
	 * use the getInstance() class.
	 * 		office = Office.getInstance();
	 * Office stores a HashMap of accounts, with key = username and value = password.
	 * It also stores the only instance of an Office object. The getInstance() class 
	 * returns a pointer to this object.
	 */
	
	private Office() {

		loadAccountInfo();
		// System.out.println(accounts); tester code for loadAccountInfo()
	}
	
	/*
	 * Returns a pointer to the officeInstance object. This will be the only Office
	 * object in the program, and everything will use it.
	 */
	public static synchronized Office getInstance() {
		
		if(officeInstance == null)
			officeInstance = new Office();
		
		return officeInstance;
	}
	
	/*
	 * Takes in an int patientID and a String[] of the patient's information. it's then
	 * written out to a .txt file. Each piece of information is written on a new line.
	 */
	public void storePatientInfo(int patientID, String[] info) throws IOException {
		File log = new File(FILEPATH + patientID + "_info.txt");
		FileWriter writer = new FileWriter(FILEPATH + patientID + "_info.txt");
		log.createNewFile();
		for (String i : info) {
			writer.write(i + "\n ");
		}
		writer.close();
	}
	
	/*
	 * Takes an int patientID and a String[] of the patient's medical history. it's then
	 * written out to a .txt file. Each piece of information is written on a new line.
	 */
	public void storeMedicalHistory(int patientID, String[] history) throws IOException {
		File log = new File(FILEPATH + patientID + "_history.txt");
		FileWriter writer = new FileWriter(FILEPATH + patientID + "_history.txt");
		log.createNewFile();
		for (String i : history) {
			writer.write(i + "\n ");
		}
		writer.close();
	}
	
	/*
	 * Takes in a String username, password, and a Role. Depending on the role of the 
	 * account that was created, a "d" for doctor, "n" for nurse, and "p" for patient
	 * is appended to the end of the password.
	 */
	public void storeAccount(String username, String password, Role role) throws IOException {
		File log = new File(FILEPATH + "accounts.txt");
		FileWriter writer = new FileWriter(FILEPATH + "accounts.txt", true); // true means it appends
		log.createNewFile();
		writer.write(username + " " + password);
		switch (role) {
			case DOCTOR: writer.write("d");
				break;
			case NURSE: writer.write("n");
				break;
			case PATIENT: writer.write("p");
				break;
		}
		writer.write("\n");
		writer.close();
	}
	
	/*
	 * Takes in an int patientID and a String[] of messages. The messages are written to a
	 * text file. All messages sent to or from the patient are stored in the same file.
	 */
	public void storeMessages(int patientID, String[] messages) throws IOException {
		File log = new File(FILEPATH + patientID + "_messages.txt");
		FileWriter writer = new FileWriter(FILEPATH + patientID + "_messages.txt", true); // true means it appends
		log.createNewFile();
		for (String m : messages) {
			writer.write(m);
		}
		writer.close();
	}
	
	/*
	 * takes in a patientID, and returns a String representation of the patient info.
	 * Each entry is separated by a new line.
	 */
	public String getPatientInfo(int patientID) throws IOException {
		
		String filePath = FILEPATH + patientID + "_info.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		StringBuilder patientInfo = new StringBuilder();
		
		reader.lines()
			  .map(l -> l.replace(" ", "\n"))
			  .forEach(patientInfo::append);
		reader.close();
		
		return patientInfo.toString();
	}
	
	/*
	 * takes in a patientID, and returns a String representation of the patient history.
	 * Each entry is separated by a new line.
	 */
	public String getMedicalHistory(int patientID) throws IOException {
		
		String filePath = FILEPATH + patientID + "_history.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		StringBuilder history = new StringBuilder();
		
		reader.lines()
			  .map(l -> l.replace(" ", "\n"))
			  .forEach(history::append);
		reader.close();
		
		return history.toString();
	}
	
	/*
	 * takes in a patientID, and returns a String representation of the messages.
	 * Each entry is separated by a new line.
	 */
	public String getMessages(int patientID) throws IOException {

		String filePath = FILEPATH + patientID + "_messages.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		StringBuilder messages = new StringBuilder();
		
		while(reader.ready()) {
			messages.append(reader.readLine());
			messages.append("\n");
		}
		reader.close();
		
		return messages.toString();
	}
	
	// not entirely sure what this guy is supposed to do. Need to ask
	public String getAccountInfo(String username, String password) {
		//FIXME: make getAccountInfo()
		return "getAccountInfo() isn't working";
	}
	
	/*
	 * loads all account info from accounts.txt into a hashmap.
	 */
	private void loadAccountInfo() {
		String filePath = FILEPATH + "accounts.txt";
		
		try(FileInputStream input = new FileInputStream(filePath)) {
			accounts = new HashMap<>();
			Properties prop = new Properties();
			prop.load(input);
			prop.forEach( (key, value) -> accounts.put( key.toString(), value.toString() ) );
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}