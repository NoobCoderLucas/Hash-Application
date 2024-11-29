import java.util.*;

public class AttendanceTracker {
    private HashMap<String, String> attendance;

    public AttendanceTracker() {
        attendance = new HashMap<>();
    }

    public void markAttendance(String studentId, String studentName) {
        attendance.put(studentId, studentName);
        System.out.println("Attendance marked for: " + studentName);
    }

    public boolean checkAttendance(String studentId) {
        return attendance.containsKey(studentId);
    }

    public void displayAttendance() {
        System.out.println("Attendance Records:");
        for (Map.Entry<String, String> entry : attendance.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " - Name: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("====================");
        System.out.println("  Attendance Tracker");
        System.out.println("====================");
        AttendanceTracker tracker = new AttendanceTracker();

        while (true) {
            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Check Attendance");
            System.out.println("3. Display All Attendance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scan.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scan.nextLine();
                    tracker.markAttendance(id, name);
                    break;
                case 2:
                    System.out.print("Enter Student ID to check: ");
                    id = scan.nextLine();
                    if (tracker.checkAttendance(id)) {
                        System.out.println("Student ID " + id + " has been marked present.");
                    } else {
                        System.out.println("Student ID " + id + " has not been marked present.");
                    }
                    break;
                case 3:
                    tracker.displayAttendance();
                    break;
                case 4:
                    System.out.println("Exiting Attendance Tracker. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
