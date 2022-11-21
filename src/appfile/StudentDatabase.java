package appfile;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabase 
{
	// map stores all student data
	private static Map<String, StudentAccounts> studentmap = new HashMap<>();

	// parameterized constructor
	public StudentDatabase() {
		studentmap.put("John", new StudentAccounts("S101", "abcd"));
		studentmap.put("Daniel", new StudentAccounts("S102", "mnop"));
	}

	// method for authentication  
	public boolean authenticateUser(String userName, String userPIN) 
	{
		// attempt to retrieve the account with the user name
		if (studentmap.containsKey(userName)) {
			if (studentmap.get(userName).getStudentPin().equals(userPIN)) {
				return true;
			}
		}
		return false;

	}

	// method return studentID
	public static String getStudentID(String username) 
	{
		if (studentmap.containsKey(username)) {

			return StudentDatabase.studentmap.get(username).getStudentID();
		}
		return null;

	}

}
