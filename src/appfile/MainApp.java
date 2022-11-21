package appfile;

import java.util.Scanner;

public class MainApp 
{
	private Boolean userAuthentication;
	private StudentDatabase studentDatabase;
	private CourseDatabase courseDatabase;
	private String currentuser;
	private Scanner scanner;
	
	private static final String Display_Courses = "a";
	private static final String View_Enroll_Courses = "b";
	private static final String Enroll_Course = "c";
	private static final String Clock_In_Time = "d";
	private static final String View_Summery = "e";
	private static final String Exit = "f";

	// constructor to instantiate variables
	public MainApp() 
	{
		userAuthentication = false;
		studentDatabase = new StudentDatabase();
		courseDatabase = new CourseDatabase();
		new Perform(currentuser);
		currentuser = "";
		scanner = new Scanner(System.in);
	}

	// method to login 
	public void run() {
		while (true) {

			while (!userAuthentication) {
				System.out.println("---- Welcome ----\n");
				autheticatedUser();

			}
			// method to perform operation
			perfromEnrolled();
			userAuthentication = false;
			currentuser = "";
			System.out.println("\n       Thank you !");
			System.out.println("------------------------------------\n\n");

		}
	}

	// authentication method
	private void autheticatedUser() 
	{
		System.out.println("Enter User Name : ");
		String user = scanner.nextLine();
		System.out.println("Enter Password : ");
		String password = scanner.nextLine();
		userAuthentication = studentDatabase.authenticateUser(user, password);
		if (userAuthentication) {
			currentuser = user;

		} 
		else 
		{
			System.out.println("Enter correct ID and Password ?");
		}

	}

	// display menu and choose option for action
	private String displayMenu() {
		System.out.println("a . Display all courses");
		System.out.println("b . View enrolled courses");
		System.out.println("c . Enroll in a new course");
		System.out.println("d . Clock-in time");
		System.out.println("e . View Summary");
		System.out.println("f . Exit");
		System.out.println("Choose option : ");
		return scanner.nextLine();

	}

	// perform action as per input 
	private void perfromEnrolled() {
		Perform enrollaction = new Perform(currentuser);
		Boolean userExit = false;
		while (!userExit) {
			String mainMenu = displayMenu();
			switch (mainMenu) {
			case Display_Courses:
				courseDatabase.displayCourses();
				break;
			case View_Enroll_Courses:
				enrollaction.viewEnrolledCourses();
				break;
			case Enroll_Course:
				enrollaction.enrollInCourse();
				break;
			case Clock_In_Time:
				
				enrollaction.clockIn();
				break;
			case View_Summery:
				enrollaction.summmary();
				break;
			case Exit:
				System.out.println("Exiting...");
				userExit = true;
			

			}
		}

	}

}
