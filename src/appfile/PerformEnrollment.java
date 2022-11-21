package appfile;

public class PerformEnrollment
{
	private String studentName;
	private String courseId;
	private String courseName;
	private String courseLevel;
	private int courseduration;
	private int timespend;
	private double completion;
	private String currentdate;
	
	// constructor to instantiate variable values
	public PerformEnrollment(String username , String enrollcid , String enrollcname ,String clevel , 
			int duration ,int timespend , float completion,String date  ) 
	{
		this.studentName=username;
		this.courseId=enrollcid;
		this.courseName=enrollcname;
		this.courseLevel=clevel;
		this.courseduration=duration;
		this.timespend=timespend;
		this.completion=completion;
		this.currentdate=date;
		
	}
	
	// get method to access courseId
	public String getCourseId() {
		return courseId;
	}

	// get method to access student name
	public String getStudentName() {
		return studentName;
	}

	// get method to access course name
	public String getCourseName() {
		return courseName;
	}

	// get method to access course level
	public String getCourseLevel() {
		return courseLevel;
	}

	// get method to access course duration
	public int getCourseduration() {
		return courseduration;
	}
	// get method to access time spent
	public int getTimespend() {
		return timespend;
	}

	// get method to access course completion
	public double getCompletion() {
		return completion;
	}
	
	// method to set completion value
	public void setCompletion(float completion)
	{
		this.completion=completion;
	}
	
	// get method to access current date
	public String getCurrentdate() {
		return currentdate;
	}
	
}