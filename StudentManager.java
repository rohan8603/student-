import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public boolean isDuplicateId(String id) {
        return students.stream().anyMatch(s -> s.getStudentId().equalsIgnoreCase(id));
    }

    public void addStudent(Student student) {
        if (!isDuplicateId(student.getStudentId())) {
            students.add(student);
            System.out.println("✔ Student added successfully!");
        } else {
            System.out.println("❌ Student ID already exists!");
        }
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        System.out.println("\n=== ALL STUDENTS ===");
        System.out.printf("%-15s %-20s %-8s %-8s %-20s\n",
                "Student ID", "Name", "Age", "Grade", "Contact");
        System.out.println("=".repeat(75));

        students.forEach(Student::display);
    }

    public Student search(String keyword) {
        return students.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(keyword) ||
                             s.getName().equalsIgnoreCase(keyword))
                .findFirst()
                .orElse(null);
    }

    public void deleteStudent(String id) {
        Student s = search(id);
        if (s != null) {
            students.remove(s);
            System.out.println("✔ Student deleted successfully!");
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    public void updateStudent(Student s, String name, int age, double grade, String contact) {
        s.setName(name);
        s.setAge(age);
        s.setGrade(grade);
        s.setContact(contact);
        System.out.println("✔ Student updated successfully!");
    }
}
