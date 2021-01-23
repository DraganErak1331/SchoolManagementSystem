package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Defines the structure of each entry(student) in the database, which will be entries of information corresponding to each student in the system.
 */
public class StudentData {
	private StringProperty id;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty dob;
	
	/**
	 * Each entry(student) of type StudentData will include a student id, the student's first name, the student's last name, the student's email, and the students date of birth.
	 * Each of these variables will be used in the cell values that they correspond to in the database table view using the AdminController class.
	 * @param id Student ID: each ID will be automatically generated via primary key auto incrementing in the database itself
	 * @param firstName Student's first name
	 * @param lastName Student's last name
	 * @param email Student's email
	 * @param dob Student's date of birth
	 */
	public StudentData(String id, String firstName, String lastName, String email, String dob) {
		this.id = new SimpleStringProperty(id);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
		this.dob = new SimpleStringProperty(dob);
	}

	/**
	 * The getter class for the StringProperty id variable.
	 * @return
	 */
	public String getID() {
		return id.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty id variable.
	 * @return
	 */
	public StringProperty IDProperty() {
		return id;
	}

	/**
	 * The setter class for the StringProperty id variable.
	 * @param id
	 */
	public void setID(String id) {
		this.id.set(id);
	}
	
	/**
	 * The getter class for the StringProperty firstName variable.
	 * @return
	 */
	public String getFirstName() {
		return firstName.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty firstName variable.
	 * @return
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * The setter class for the StringProperty firstName variable.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	/**
	 * The getter class for the StringProperty lastName variable.
	 * @return
	 */
	public String getLastName() {
		return lastName.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty lastName variable.
	 * @return
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * The setter class for the StringProperty lastName variable.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
	/**
	 * The getter class for the StringProperty email variable.
	 * @return
	 */
	public String getEmail() {
		return email.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty email variable.
	 * @return
	 */
	public StringProperty emailProperty() {
		return email;
	}

	/**
	 * The setter class for the StringProperty email variable.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email.set(email);
	}
	
	/**
	 * The getter class for the StringProperty email variable.
	 * @return
	 */
	public String getDOB() {
		return dob.get();
	}
	
	/**
	 * The StringProperty class for the StringProperty dob variable.
	 * @return
	 */
	public StringProperty DOBProperty() {
		return dob;
	}

	/**
	 * The setter class for the StringProperty dob variable.
	 * @param DOB
	 */
	public void setDOB(String DOB) {
		this.dob.set(DOB);
	}
	
	
	
}
