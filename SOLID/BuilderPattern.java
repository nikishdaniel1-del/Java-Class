package SOLID;

class Student {
    private int id;
    private String name, course;
    private int year;
    private double fees;
    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.course = builder.course;
        this.year = builder.year;
        this.fees = builder.fees;
    }
    public void display() {
        System.out.println(id + " - " + name + " - " + course + " - " + year + " - " + fees);
    }
    static class StudentBuilder {
        private int id;
        private String name, course;
        private int year;
        private double fees;
        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }
        public StudentBuilder setYear(int year) {
            this.year = year;
            return this;
        }
        public StudentBuilder setFees(double fees) {
            this.fees = fees;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder()
                .setId(1)
                .setName("Nikish Daniel")
                .setCourse("AI&DS")
                .setYear(3)
                .setFees(100000)
                .build();
        student.display();
    }
}