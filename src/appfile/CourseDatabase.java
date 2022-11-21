package appfile;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CourseDatabase 
{
	// map stores all course data 
	private static  Map<String ,Course> course  = new TreeMap<>();
	
	// constructor to instantiate variables
	public CourseDatabase() 
	{
		course.put("C1",new Course("Java Basic", "Low",3));
		course.put("C2",new Course("Advanced Java Tutorial", "Medium",4));
		course.put("C3",new Course("SQL Developers Course", "Medium",4));
		course.put("C4",new Course("DevOps Tutorial", "High",5));
	}
	
	// display all course data
	public void displayCourses() 
	{
		System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-18s%-30s%-20s%-2s","Course Id", "Course Name", "Difficulty Level", "Duration");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        for (Entry<String , Course> mp : course.entrySet()) {
            System.out.printf("%-18s%-30s%-20s%-2s", mp.getKey() , mp.getValue().getCourseName(), mp.getValue().getLevel(),mp.getValue().getDuration()+"hrs");
            System.out.println();
		
		
		}
        System.out.println("--------------------------------------------------------------------------------");
	}
	


	// getter method to access curses data
	public Map<String, Course> getCourse() {
		return course;
	}

}