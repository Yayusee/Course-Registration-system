 interface Student {
    public String getName();
    public void setName(String name);
    public int getId();
    public void setId(int id);
    public String getEmail();
    public void setEmail(String email);
}

 interface Course {
    public String getName();
    public void setName(String name);
    public int getId();
    public void setId(int id);
    public int getCredits();
    public void setCredits(int credits);
}

 interface Registration {
    public void createRegistration(Student student, Course course) throws RegistrationException;
    public void updateRegistration(Student student, Course course) throws RegistrationException;
    public RegistrationRecord getRegistrationRecord(Student student, Course course) throws RegistrationException;
    public boolean verifyPrerequisites(Student student, Course course) throws RegistrationException;
    public boolean checkAvailability(Course course) throws RegistrationException;
}

public class RegistrationException extends Exception {
    public RegistrationException(String message) {
        super(message);
    }
}
class main{

public static void main(String[] args) {
    Student student = new StudentImpl();
    student.setName("John Doe");
    student.setId(12345);
    student.setEmail("jdoe@example.com");
    
    Course course = new CourseImpl();
    course.setName("Introduction to Java Programming");
    course.setId(101);
    course.setCredits(3);
    
    Registration registration = new RegistrationImpl();
    
    try {
        if (registration.checkAvailability(course) && registration.verifyPrerequisites(student, course)) {
            registration.createRegistration(student, course);
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration unsuccessful.");
        }
    } catch (RegistrationException e) {
        System.out.println("Registration failed: " + e.getMessage());
    }
}