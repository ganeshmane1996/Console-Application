package appfile;

public class StudentAccounts 
{
	private String studentID;
	private String studentPin;
	
	// StudentAccount constructor initializes attributes
	
	public StudentAccounts (String id,String pin)
	{
		studentID = id;
		studentPin = pin;
	}
	
	// get studentID
	public String getStudentID() {
		return studentID;
		}

	// get studentPin
	public String getStudentPin() {
		return studentPin;
	}
	

}
