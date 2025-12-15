public class Student {
    private String studentId;
    private String name;
    private int age;
    private double grade;
    private String contact;

    public Student(String studentId, String name, int age, double grade, String contact) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.contact = contact;
    }

    // Getters & Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { 
        if (!name.isBlank()) this.name = name;
        else System.out.println("Name cannot be empty!");
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age > 0) this.age = age;
        else System.out.println("Age must be positive!");
    }

    public double getGrade() { return grade; }
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) this.grade = grade;
        else System.out.println("Grade must be between 0 and 100!");
    }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public void display() {
        System.out.printf("%-15s %-20s %-8d %-8.2f %-20s\n",
                studentId, name, age, grade, contact);
    }
}
