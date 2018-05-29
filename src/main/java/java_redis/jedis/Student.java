package java_redis.jedis;

//POJO used for showing how jedis works to communicate with redis caching system
public class Student {
	
	private String Name;
	private String Birthday;
	private String IDNumber;
	private String GPA;
	
	public Student() {
		
	}
	public Student(String name, String birthday, String idNumber, String GPA) {
		this.Name = name;
		this.Birthday = birthday;
		this.IDNumber = idNumber;
		this.GPA = GPA;
	}
	
	//Getter and Setter for name
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
	//Getter and Setter for Birthday
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		this.Birthday = birthday;
	}
	
	//Getter and Setter for IDNumber
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		this.IDNumber = iDNumber;
	}
	
	//Getter and Setter for GPA
	public String getGPA() {
		return GPA;
	}
	public void setGPA(String GPA) {
		this.GPA = GPA;
	}
	
}