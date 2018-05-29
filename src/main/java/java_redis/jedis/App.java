package java_redis.jedis;

//Jedis is a java project designed to allow communication from java with locally running redis server
import redis.clients.jedis.Jedis;

public class App 
{
	//A private int that tracks the number of entries in the redis server
	private static int userCount = 1;
	
    public static void main (String[] args)
    {	
    	Jedis jedis = new Jedis();	//Starts a new Jedis connection to the redis server
    	Student newStudent = new Student("Connor", "04/06/1998", "1325231", "3.5");
    	storeStudent(newStudent, jedis);	//Stores the first student with key user1 in the redis server
    	
    	Student newStudent2 = new Student("Joe", "01/01/1998", "2315231", "4.5");
    	storeStudent(newStudent2, jedis);	//Stores the second student with key user2 in the redis server
    	
    	String cachedResponse = jedis.hget("user2", "birthday");
    	System.out.println(cachedResponse);		//Gets and then outputs the value associated with label "birthday" in key "user2"
    	
    	jedis.hset("user2", "birthday", "01/31/2018");
    	cachedResponse = jedis.hget("user2", "birthday");
    	System.out.println(cachedResponse); //Updates and prints out label "birthday" for key "user2" 
    	
    	cachedResponse = jedis.hget("user3", "Birthday");
    	System.out.println(cachedResponse);	//Returns "null" as there is no user3 initiated in the redis server yet
    	jedis.close();	//Closes the Jedis connection to the redis server
    }
    
    //Helper method used to store students information into the redis server
    public static void storeStudent(Student store, Jedis jedis){
    	
    	String userNumber = "user";
    	userNumber = userNumber + Integer.toString(userCount);		//Creates the next name (user1, user2, user3) used as the key in the redis server
    	
    	jedis.hset(userNumber, "name", store.getName());			//This four lines set the entries for each key in the redis server
    	jedis.hset(userNumber, "birthday", store.getBirthday());
    	jedis.hset(userNumber, "IDNumber", store.getIDNumber());
    	jedis.hset(userNumber, "GPA", store.getGPA());
    	
    	userCount += userCount;		//Increments the count of the entries in the redis database
    }
}
