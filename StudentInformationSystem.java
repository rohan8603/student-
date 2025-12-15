import java.util.Scanner;

public class StudentInformationSystem {

    private static Scanner sc = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = getInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> manager.viewAll();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Thank you for using the system!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = getInt();

        System.out.print("Enter Grade (0-100): ");
        double grade = getDouble();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        manager.addStudent(new Student(id, name, age, grade, contact));
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID or Name: ");
        String key = sc.nextLine();

        Student s = manager.search(key);

        if (s != null) {
            System.out.println("\nStudent Found:");
            s.display();
        } else {
            System.out.println("❌ No match found!");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        String id = sc.nextLine();

        Student s = manager.search(id);

        if (s == null) {
            System.out.println("❌ Student not found!");
            return;
        }

        System.out.println("Enter Updated Details:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = getInt();

        System.out.print("Grade (0-100): ");
        double grade = getDouble();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        manager.updateStudent(s, name, age, grade, contact);
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        String id = sc.nextLine();
        manager.deleteStudent(id);
    }

    // Validation-safe input
    private static int getInt() {
        while (true) {
            try { return Integer.parseInt(sc.nextLine()); }
            catch (Exception e) { System.out.print("Enter valid number: "); }
        }
    }

    private static double getDouble() {
        while (true) {
            try { return Double.parseDouble(sc.nextLine()); }
            catch (Exception e) { System.out.print("Enter valid number: "); }
        }
    }
}
