package appfile;

public class Course 
{
	private String courseName;
	private String level;
	private int duration;
	
	//parameterized constructor to initialize the variable
	public Course (String courseName,String level ,int duration )
	{
		this.courseName=courseName;
		this.level=level;
		this.duration=duration;
	}
	
	// get method to access Course Name
	public String getCourseName() {
		return courseName;
	}
	
	// get method to access Course Level
	public String getLevel() {
		return level;
	}
    
	// get method to access Course Duration
	public int getDuration() {
		return duration;
	}

}
