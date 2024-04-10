package application;

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
	
	/*****
	 * Office is a singleton class. The constructor CANNOT be called. Instead, you have to
	 * use the getInstance() class.
	 * 		office = Office.getInstance();
	 * Office stores a HashMap of accounts, with key = username and value = password.
	 * It also stores the only instance of an Office object. The getInstance() class 
	 * returns a pointer to this object.
	 */
	
	private Office() {

		accounts = new HashMap<>();
		loadAccountInfo();
	}
	
	/*****
	 * loads all account info from accounts.txt into a hashmap.
	 */
	private void loadAccountInfo() {
		String filePath = FILEPATH + "accounts.txt";
		
		try(FileInputStream input = new FileInputStream(filePath)) {
			Properties prop = new Properties();
			prop.load(input);
			prop.forEach( (key, value) -> accounts.put( key.toString(), value.toString() ) );
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*****
	 * Returns a pointer to the officeInstance object. This will be the only Office
	 * object in the program, and everything will use it.
	 */
	public static synchronized Office getInstance() {
		
		if(officeInstance == null)
			officeInstance = new Office();
		
		return officeInstance;
	}
	
	
	
	
	
	
	/* ----- These are the methods you'll actually use ----- */
	
	/*****
	 * Takes in an int patientID and a String[] of the patient's information. it's then
	 * written out to a .txt file. Each piece of information is written on a new line.
	 */
	public void storePatientInfo(int patientID, String[] info) throws IOException {
		
		File log = new File(FILEPATH + patientID + "_info.txt");
		FileWriter writer = new FileWriter(FILEPATH + patientID + "_info.txt");
		log.createNewFile();
		
		for (String i : info) {
			writer.write(i + "\n");
		}
		writer.close();
	}
	
	
	
	/*****
	 * Takes an int patientID and a String[] of the patient's medical history. it's then
	 * written out to a .txt file. Each piece of information is written on a new line.
	 */
	public void storeMedicalHistory(int patientID, String[] history) throws IOException {
		
		String date = java.time.LocalDate.now().toString();
		String filePath = FILEPATH + patientID + "/" + patientID + "_" + date + "_history.txt"; // src/records/patientID/patientID_date_history.txt
		File log = new File(filePath);
		if (!log.exists()) {
			log.mkdirs();
		}
		FileWriter writer = new FileWriter(filePath);
		log.createNewFile();
		
		writer.write(date + "\n");
		for (String i : history) {
			writer.write(i + "\n");
		}
		writer.close();
	}
	
	
	
	/*****
	 * Takes in a String username, password, and a Role. Depending on the role of the 
	 * account that was created, a "d" for doctor, "n" for nurse, and "p" for patient
	 * is appended to the end of the password.
	 */
	public void storeAccount(String username, String password, Actor.Role role) throws IOException {
		
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
		loadAccountInfo();
	}
	
	
	
	/*****
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
	
	
	
	/*****
	 * takes in a patientID, and returns a String representation of the patient info.
	 * Each entry is separated by a new line.
	 */
	public String getPatientInfo(int patientID) throws IOException {
		
		String filePath = FILEPATH + patientID + "_info.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		StringBuilder patientInfo = new StringBuilder();
		
		while(reader.ready()) {
			patientInfo.append(reader.readLine());
			patientInfo.append("\n");
		}
		reader.close();
		
		return patientInfo.toString();
	}
	
	
	
	/******
	 * takes in an int patientID and String date, and returns a String representation 
	 * of the patient history. Each entry is separated by a new line. The date should 
	 * only be gotten from getVisitDates.
	 */
	public String getMedicalHistory(int patientID, String date) throws IOException {
		
		String filePath = FILEPATH + patientID + "/" + patientID + "_" + date + "_history.txt"; // src/records/patientID/patientID_date_history.txt
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		StringBuilder history = new StringBuilder();
		
		while(reader.ready()) {
			history.append(reader.readLine());
			history.append("\n");
		}
		
		reader.close();
		
		return history.toString();
	}
	
	
	
	/*****
	 * given an int patientID, returns a string array containing all of the
	 * visit dates in the records.
	 */
	public String[] getVisitDates(int patientID) throws IOException {
		
		String filePath = FILEPATH + patientID; // src/records/<patientID>
		File path = new File(filePath);
		File files[] = path.listFiles();
		String dates[] = new String[files.length];
		BufferedReader reader[] = new BufferedReader[files.length];
		
		for(int i = 0; i < files.length; i++) {
			reader[i] = new BufferedReader(new FileReader(files[i]));
			dates[i] = reader[i].readLine();
		}
		return dates;
	}
	
	
	
	/*****
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
	
	
	
	/*****
	 * Takes a username and password. If they are valid, it returns the account's role.
	 * If they are invalid, returns null.
	 */
	public Actor.Role checkAccountType(String username, String password) {
		
		Actor.Role userRole = null;
		
		if(accounts.containsKey(username) == false)
			return userRole;
		
		String actual = accounts.get(username);
		char role = actual.charAt(actual.length() - 1);
		actual = actual.substring(0, actual.length() - 1);
		
		if(password.equals(actual)) {
			
			switch (role) {
				case 'n':
					userRole = Actor.Role.NURSE;
					break;
				case 'd':
					userRole = Actor.Role.DOCTOR;
					break;
				case 'p':
					userRole = Actor.Role.PATIENT;
					break;
				default:
					userRole = null;
			}
		}
		return userRole;
	}
}
