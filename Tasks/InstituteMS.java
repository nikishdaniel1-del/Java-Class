package Tasks;
import java.util.*;

class Institute{
    int courseID,seats;
    String courseName,trainer;
    double price;
    Institute(int courseID,String courseName,String trainer,int seats) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.trainer = trainer;this.seats=seats;}
    void display(){
        System.out.println(
        String.format("Course Details :\nCourse ID    : %d\nCourse Name  : %s\nTrainer Name : %s\nCourse Price : %.2f\nAvailable Seats : %d",
        courseID,courseName,trainer,price,seats));}
    void validateFee(double price){
        if (price>0) this.price=price;
        else this.price=0;}}

public class InstituteMS {
    public static void main(String[] args) {
        HashMap<Integer,Institute> courses = new HashMap<>();
        HashMap<Integer,ArrayList<int[]>> student = new HashMap<>();
        Scanner terminal = new Scanner(System.in);
        while (true){
            System.out.print("Enter the Operation 1.Add Courses 2.Student's Registration 3.Course Completion 4.Student's Details 5.Exit : ");
            int operation = terminal.nextInt();
            if (operation==1){
                System.out.print("Enter Course ID : ");
                int id = terminal.nextInt();
                terminal.nextLine();
                if (courses.containsKey(id)){System.out.println("Course Already Exists");continue;}
                System.out.print("Enter Course Name : ");
                String courseName = terminal.nextLine();
                System.out.print("Enter Trainer Name : ");
                String trainer = terminal.nextLine();
                System.out.print("Enter Course Price : ");
                double price = terminal.nextDouble();
                System.out.print("Enter Course Seats : ");
                int seats = terminal.nextInt();
                Institute currentCourse = new Institute(id, courseName, trainer, seats);
                currentCourse.validateFee(price);
                courses.put(id, currentCourse);
                System.out.println("Course Added Successfully.");}
            else if (operation==2){
                int newCheck = 1;
                System.out.println("=".repeat(9)+"Available Courses"+"=".repeat(9));
                for (int course:courses.keySet()){
                    Institute currentCourse = courses.get(course);
                    if (currentCourse.seats!=0)System.out.println(currentCourse.courseID+". "+currentCourse.courseName);}
                System.out.print("=".repeat(35)+"\nEnter the Course ID to Register : ");
                int id = terminal.nextInt();
                if (!courses.containsKey(id)){System.out.println("Course doesn't Exists");continue;}
                else if (courses.get(id).seats==0){System.out.println("Course Already Filled");continue;}
                Institute currentCourse = courses.get(id);
                currentCourse.display();
                System.out.print("Enter your ID : ");
                int studentId = terminal.nextInt();
                student.putIfAbsent(studentId, new ArrayList<>());
                for (int[] courseId : student.get(studentId)) {
                    if (courseId[0]==id){
                        String status = (courseId[1]!=0) ? "Completed":"Registered";
                        System.out.println(String.format("You've already %s this course.",status));
                        newCheck=0;break;}}
                if (newCheck==0)continue;
                System.out.print("Would You like to register (Y/N) : ");
                String option = terminal.next();
                if (option.toLowerCase().equals("y")) {
                    currentCourse.seats--;
                    student.get(studentId).add(new int[]{id,0});
                    System.out.println("You've Enrolled Successfully.");}}
            else if (operation==3){
                System.out.print("Enter Your ID : ");
                int studentId = terminal.nextInt();
                try {
                    System.out.print("Enter the courses you've completed (course Id : obtained Mark) ',' separated for more. -1 to exit: ");
                    String completed = terminal.next();
                    for (String marks:completed.split(",")){
                        String[] parts = marks.split(":");
                        int id = Integer.parseInt(parts[0]);
                        int mark = Integer.parseInt(parts[1]);
                        for (int[] current : student.get(studentId)){if (current[0]==id){current[1]=mark;break;}}}
                } catch (Exception e) {System.out.println("You haven't registered any courses yet.");}}
            else if (operation==4){
                int total = 0,max = 0,min = 0,count = 0;
                System.out.print("Enter Your Id : ");
                int studentId = terminal.nextInt();
                try{
                System.out.println("Your Course : ");
                    for (int[] id:student.get(studentId)){
                        Institute currentStatus = courses.get(id[0]);
                        int marksOb = id[1];
                        total = total+marksOb;
                        if (marksOb>max){max=marksOb;}
                        else if (marksOb<min){min=marksOb;}
                        String status = (marksOb!=0) ? "Completed":"Registered";
                        System.out.println("=".repeat(35));
                        System.out.println(String.format("Course ID    : %d\nCourse Name  : %s\nTrainer Name : %s\nMarks Obtained : %d\nCourse Status : %s", 
                        currentStatus.courseID,currentStatus.courseName,currentStatus.trainer,marksOb,status));
                        count++;}
                    System.out.println("=".repeat(35));
                    System.out.println(String.format("Total Marks Obtained : %d\nAverage Marks : %.2f\nMinimum : %d\nMaximum : %d", total,(double) total/count,min,max));}
                    catch (Exception e){System.out.println("Student ID doesn't Exists.");}}
            else if (operation==5)break;
            else System.out.println("Invalid Operation.");}}}