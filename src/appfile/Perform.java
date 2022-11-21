package appfile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perform {
	
	private static List<PerformEnrollment> enrollcourselist = new ArrayList<>();
	private static String studentName;
	private int timespent;
	private float completion;
	private Scanner scanner;
	
	private CourseDatabase courseDatabase;

	// parameterized constructor 
	public Perform(String user) {
		studentName = user;
		scanner = new Scanner(System.in);

		courseDatabase=new CourseDatabase();
	}

	// method to enroll a course
	public void enrollInCourse()
	{
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy ");
			LocalDateTime now = LocalDateTime.now();
			String currdate = dtf.format(now);
			System.out.println("Enter CourseID : ");
			String cid = scanner.nextLine();
			String cname = courseDatabase.getCourse().get(cid).getCourseName();
			String clevel = courseDatabase.getCourse().get(cid).getLevel();
			int cduration = courseDatabase.getCourse().get(cid).getDuration();
			// check entered courseId matches in available courses
			if (courseDatabase.getCourse().containsKey(cid)) {
				System.out.println("You have enrolled in " + cname +"\n");
				enrollcourselist.add(new PerformEnrollment(studentName, cid, cname, clevel, cduration, timespent, completion, currdate));

				}
			}
		catch (Exception e){ 
			System.out.println("Enter valid course ID ! \n");
			}
	}

	// method to display enrolled courses
	public void viewEnrolledCourses()
	{
		System.out.println("Student Name : " + studentName);
		System.out.println("Student Id : " + StudentDatabase.getStudentID(studentName));
		if (enrollcourselist.isEmpty()) {
			System.out.println("You have not enrolled any course. Please enroll it !");
		} 
		else 
		{
			System.out.println("-----------------------------------------------------------------");
			System.out.printf("%-18s%-30s%-2s", "Course Id", "Course Name", "Enrollment Date\n");
			System.out.println("-----------------------------------------------------------------");
			for (PerformEnrollment p : enrollcourselist) {
                // display enrolled course for logged user
				if (p.getStudentName().contains(studentName)) {

					System.out.printf("%-18s%-30s%-2s", p.getCourseId(), p.getCourseName(), p.getCurrentdate());
					System.out.println();
				}
				

			}
			System.out.println("-----------------------------------------------------------------");

		}

	}

	// method to set time spend for respective course
	public void clockIn() 
	{
		try {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter Course Id : ");
		String enrolledCid = scanner.nextLine();
		System.out.println("Enter Time Spent : ");
		int spendtime = input.nextInt();
		
		for (int i = 0; i < enrollcourselist.size(); i++)
		{
			// check for user and it's enrolled course,then update time for courseId
			if (enrollcourselist.get(i).getStudentName().equals(studentName) && enrollcourselist.get(i).getCourseId().equals(enrolledCid)) 
			{

				int totalTimeSpent = enrollcourselist.get(i).getTimespend() + spendtime;
				
				if(totalTimeSpent<=enrollcourselist.get(i).getCourseduration()) {
					float completion = (totalTimeSpent * 100) / enrollcourselist.get(i).getCourseduration();
					enrollcourselist.set(i,new PerformEnrollment(studentName, enrollcourselist.get(i).getCourseId(),
					enrollcourselist.get(i).getCourseName(), enrollcourselist.get(i).getCourseLevel(),
					enrollcourselist.get(i).getCourseduration(), totalTimeSpent, completion, enrollcourselist.get(i).getCurrentdate()));
					System.out.printf("You have successfully clocked-in %d hrs to %s \n",spendtime,enrollcourselist.get(i).getCourseName());
					}
				else {
					System.out.println("\nTime spent more than course duration !\n");
				}
				}
				
			}
		}catch(Exception e) {
			System.out.println("\nEnter time in Hrs !\n");
		}
			
	}

		
	// method to display summary of courses
	public void summmary() 
	{
		System.out.println("Student Name : " + studentName);
		System.out.println("Student Id : " + StudentDatabase.getStudentID(studentName));
		// check enrolled course list for logged user
		if (enrollcourselist.isEmpty()) {
			System.out.println("You have not enrolled any course. Please enroll it !");
		} 
		else 
		{
			System.out.println("--------------------------------------------------------------------------------");
			System.out.printf("%-18s%-25s%-12s%-13s%-10s", "Course Id", "Course Name", "Duration", "Time Spent",
					"Completion %");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			for (PerformEnrollment data : enrollcourselist) {
                // check for logged student and print respective data
				if (data.getStudentName().equals(studentName)) {
					System.out.printf("%-18s%-27s%-13s%-12s%-5s", data.getCourseId(), data.getCourseName(),
							data.getCourseduration(), data.getTimespend(), data.getCompletion());
					System.out.println();
				}

			}
			System.out.println("--------------------------------------------------------------------------------");
		}
	}

}
