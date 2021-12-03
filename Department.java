import java.util.HashSet;
import java.util.Vector;
import java.util.Random;

public class Department {
   private String name; // the name of school Dept of Computing and Info Science
   private String id; // short name for courses SOFE, ELEE, STAT, etc
   private Vector<Course> courseList; // all courses offered by the department
   private Vector<Student> registerList; // all students taking courses in the department.

   Random rand = new Random();
   
   public Department(String name, String id) {
      //initialize name and id
      name = this.name;
      id = this.id;
      //create new vectors to store lists of courses and students
      Vector<Course> courselist = new Vector<Course>();
      Vector<Student> registerlist = new Vector<Student>();
           }
   public String getName() {
      return name;
   }
   public String getId() {
      return id;
   }
   public String toString() {
      // returns a string representation of department name, number 
      // of courses offered and number of students registered in the
      // department. Use the format:
      // ECSE: 53 courses, 460 students
      System.out.println(name+ ": " + courseList.size() + " courses, " + registerList.size() + " students");
      return null;
   }
   public void offerCourse(Course course){
      courseList.add(course);
   }
   public void printCoursesOffered(){
      for (int i = 0; i < courseList.size(); i++){
         courseList.elementAt(i).toString();
      }
   }
   public void addStudentToRegister(Student stud){
      if (isStudentRegistered(stud)) {
         registerList.add(stud);
      }
   }
   public boolean isStudentRegistered(Student student){
     return (registerList.contains(student));
   }
   public Vector<Student> studentsRegisteredInCourse(int code){

      boolean found = false;
      Vector<Student> studentsInCourse = new Vector<Student>();
      for (int i = 0; i < courseList.size(); i ++){
         if (code==((courseList.elementAt(i)).getCode())){
            studentsInCourse = (courseList.elementAt(i)).getClassList();
            found =true;
            break;
         }
      }
      if (found){
         return studentsInCourse;
      } else {
         System.out.println("This course is not taught in this department.");
         return null;
      }
   }
   public void printStudentsRegisteredInCourse(int code){
      System.out.println("These are the students enrolled in " + id + code + ": ");
      int hold, size;
      Vector<Student> courseStudents = studentsRegisteredInCourse(code);
      size = courseStudents.size();
      Vector<Student> copy = new Vector<Student>(size);
      for (int i = 0; i < size; i++){
         do {
            hold = rand.nextInt(size);
         } while (!(copy.contains(courseStudents.elementAt(hold))));
         copy.add(courseStudents.elementAt(hold));
         (courseStudents.elementAt(hold)).toString();
      }
   }
}
