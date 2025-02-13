import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Responsible for recording Student progress, and maintaining user infor between sessions
 * @author MUMAWBM1
 *
 */
public class Student {

	private String username;
	private String password;
	
	//AP topics
	private Map<String,Tuple> stats;

	//test grades stored as %
	private ArrayList<Double> tests;

	//private Tuple bloom;

	/**
	 * default Student Object Constructor
	 * sets username and password to guest by default
	 * (used mostly for file generation)
	 */
	public Student(){
		stats = new HashMap<>();
		tests = new ArrayList<>();

		//TODO: file readers and writers (specifically for txt files) maybe look at streams for doing numbers?
		FileInputStream fis = null;
		DataInputStream dis = null;
		username = "guest";
		password = "guest";
		String fname = "guest" + password.hashCode() + ".bin";
		try {
			fis = new FileInputStream(fname);
			dis = new DataInputStream(fis);
		}
		catch (FileNotFoundException e) {
			generateFile(fname);
			try {
				fis = new FileInputStream(fname);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			dis = new DataInputStream(fis);
		} 
		//this.username = "guest";
		//this.password = "guest";
		Tuple t;	//for bloom only atm
		String name = "";
		try {
			for(int i = 0;i<4;i++) {
				tests.add(dis.readDouble());
			}
			for (int i = 1;i<7;i++) {
				name = ("Bloom "+i);
				t = new Tuple(dis.readInt(),dis.readInt());
				stats.put(name,t);
			}
			name = ("Comments");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = ("Primitive Types");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Operators";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Object Comparison";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Escape Sequences";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "I/O";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Exceptions";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Arrays";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Control Statements";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Variables";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Methods";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Constructors";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Classes";
			t = new Tuple(dis.readInt(),dis.readInt());	
			stats.put(name,t);
			name = "Interfaces";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Inheritance";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Packages";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Miscellaneous Object Oriented Programming";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Standard Java Library";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * enhanced Student Constructor
	 * allows for multiple accounts
	 * (still only used for file generation)
	 * @param username
	 * @param password
	 */
	public Student(String username, String password){
		stats = new HashMap<>();
		tests = new ArrayList<>();

		//TODO: file readers and writers (specifically for txt files) maybe look at streams for doing numbers?
		FileInputStream fis = null;
		DataInputStream dis = null;
		this.username = username;
		this.password = password;
		String fname = username + password.hashCode() + ".bin";
		try {
			fis = new FileInputStream(fname);
			dis = new DataInputStream(fis);
		}
		catch (FileNotFoundException e) {
			generateFile(fname);
			try {
				fis = new FileInputStream(fname);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			dis = new DataInputStream(fis);
		} 
		//this.username = "guest";
		//this.password = "guest";
		Tuple t;	//for bloom only atm
		String name = "";
		try {
			for(int i = 0;i<4;i++) {
				tests.add(dis.readDouble());
			}
			for (int i = 1;i<7;i++) {
				name = ("Bloom "+i);
				t = new Tuple(dis.readInt(),dis.readInt());
				stats.put(name,t);
			}
			name = ("Comments");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = ("Primitive Types");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Operators";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Object Comparison";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Escape Sequences";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "I/O";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Exceptions";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Arrays";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Control Statements";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Variables";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Methods";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Constructors";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Classes";
			t = new Tuple(dis.readInt(),dis.readInt());	
			stats.put(name,t);
			name = "Interfaces";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Inheritance";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Packages";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Miscellaneous Object Oriented Programming";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Standard Java Library";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public Map<String,Tuple> getStats(){
		return stats;
	}
	
	public ArrayList<Double> getTests() {
		return tests;
	}

	public void addTest(Double score, int testNumber) {
		if(tests.get(testNumber)<score) {
			tests.set(testNumber,score);
			saveProgress();
		}
	}

	/**
	 * Deletes, then remakes file with updated info
	 * Needed to use this work around because DataOutputStream writeInt doesn't overwrite, it appends(at least experienced this)
	 */
	public void saveProgress() {
		String fname = username + password.hashCode() + ".bin";
		File f1 = new File(fname);
		f1.delete();
		try {
			FileOutputStream f = new FileOutputStream(fname);
			DataOutputStream dos = new DataOutputStream(f);
			try {

				for (int i = 0; i<tests.size();i++) {
					dos.writeDouble(tests.get(i));
				}
				for(int i = 1; i<7;i++) {
					dos.writeInt(stats.get("Bloom "+i).getX());
					dos.writeInt(stats.get("Bloom "+i).getY());
				}
				dos.writeInt(stats.get("Comments").getX());
				dos.writeInt(stats.get("Comments").getY());
				dos.writeInt(stats.get("Primitive Types").getX());
				dos.writeInt(stats.get("Primitive Types").getY());
				dos.writeInt(stats.get("Operators").getX());
				dos.writeInt(stats.get("Operators").getY());
				dos.writeInt(stats.get("Object Comparison").getX());
				dos.writeInt(stats.get("Object Comparison").getY());
				dos.writeInt(stats.get("Escape Sequences").getX());
				dos.writeInt(stats.get("Escape Sequences").getY());
				dos.writeInt(stats.get("I/O").getX());
				dos.writeInt(stats.get("I/O").getY());
				dos.writeInt(stats.get("Exceptions").getX());
				dos.writeInt(stats.get("Exceptions").getY());
				dos.writeInt(stats.get("Arrays").getX());
				dos.writeInt(stats.get("Arrays").getY());
				dos.writeInt(stats.get("Control Statements").getX());
				dos.writeInt(stats.get("Control Statements").getY());
				dos.writeInt(stats.get("Variables").getX());
				dos.writeInt(stats.get("Variables").getY());
				dos.writeInt(stats.get("Methods").getX());
				dos.writeInt(stats.get("Methods").getY());
				dos.writeInt(stats.get("Constructors").getX());
				dos.writeInt(stats.get("Constructors").getY());
				dos.writeInt(stats.get("Classes").getX());
				dos.writeInt(stats.get("Classes").getY());
				dos.writeInt(stats.get("Interfaces").getX());
				dos.writeInt(stats.get("Interfaces").getY());
				dos.writeInt(stats.get("Inheritance").getX());
				dos.writeInt(stats.get("Inheritance").getY());
				dos.writeInt(stats.get("Packages").getX());
				dos.writeInt(stats.get("Packages").getY());
				dos.writeInt(stats.get("Miscellaneous Object Oriented Programming").getX());
				dos.writeInt(stats.get("Miscellaneous Object Oriented Programming").getY());
				dos.writeInt(stats.get("Standard Java Library").getX());
				dos.writeInt(stats.get("Standard Java Library").getY());
				dos.flush();
				dos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * Generates a template file for a Student object, to be read in for first time user (has no data beyond 0's in everything)
	 * @param filename
	 */
	public void generateFile(String filename){;
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataOutputStream dos = new DataOutputStream(fos);
		try {
			for(int i = 0;i<4;i++) {
				dos.writeDouble(0.0);
			}
			for(int i = 0;i<12;i++) {
				dos.writeInt(0);
			}
			for(int i=0;i<18;i++) {
				for(int j = 0;j<2;j++) {
					dos.writeInt(0);
				}
			}
			dos.flush();
			dos.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		return;
	}
	
	public Student resetProgress() {
		String filename = username+password.hashCode() + ".bin";
		generateFile(filename);
		return new Student(username,password);
	}
	
	/**
	 * logs in non-guest user into their account
	 * @param username
	 * @param password
	 * @return	a reference to the Student referend to by the username and password loaded up and rarin' to go
	 */
	public Student login(String username,String password) {
		String filename = username+password.hashCode() + ".bin";
		try {
			FileInputStream fis = new FileInputStream(filename);
			fis.close();
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			System.out.println("This will never print.");
			return new Student(username,password);
		}
		return new Student(username,password);
	}
	
	/**
	 * Used for testing, making sure both Students are pulling from the same file
	 * @param o	Object to compare equality
	 * @return true or false equaltiy
	 */
	public boolean equals(Student o) {
		if(o.getUsername().equals(this.username) && o.getPassword().equals(this.password)) {
			return true;
		}
		return false;
	}

}