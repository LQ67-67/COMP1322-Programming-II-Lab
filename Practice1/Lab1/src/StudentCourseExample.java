class Student {
    String name;
    int studentId;

    // Constructor to initialize student
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    // Enroll student in a course
    public void enrollInCourse(Course course) {

        System.out.println(name + " enrolled in " + course.courseName);
    }
}

class Course {
    String courseName;
    String courseCode;

    // Constructor to initialize course
    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }


    public void displayInfo() {

        System.out.println("Course: " + courseName + " (" + courseCode + ")");
    }
}

public class StudentCourseExample {
    public static void main(String[] args) {
        Student student1 = new Student("Liu Qi", 36557854);

        Course programming = new Course("Programming II", "COMP1322");

        programming.displayInfo();
        student1.enrollInCourse(programming);
    }
}
