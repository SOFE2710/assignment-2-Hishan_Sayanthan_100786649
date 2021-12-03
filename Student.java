import java.util.Vector;
public class Student extends Person{   
  private String id;
  private String name;
  private Vector courses; // contains all courses the student is registered in

    public Student(String stdId, String stdName) {
	   super(stdName);
     id=stdId;
     Vector<Course>courses = new Vector<Course>();
	}
     public String getName() {
  		 	 return name;
  	  }
  	  public String getId() {
        return id;
  	  } 	  
    public String toString() {
     // return a string representation of a student using the following format:
     // 100234546 John McDonald
     // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
     System.out.println(id+""+name);
     System.out.println("Registered courses: "+courses);
	return null; 
  }
  public void registerFor(Course course){
    if (!(courses.contains(course))){
      courses.add(course);//This would add the course to the student's list
      course.addToClassList(this);//This would add the student name to the class list
      course.addStudToRegister(this); //this would add the student's name to the department's registerList
}
}
//This boolean would determine whether the student is in a specific course or not
public Boolean isRegisteredInCourse(Course course){
return courses.contains(course);//It would be returned true if the couse is found
}
}