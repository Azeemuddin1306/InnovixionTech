import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private HashMap<String, Double> grades; // course -> grade

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String course, double grade) {
        grades.put(course, grade);
    }

    public void removeGrade(String course) {
        grades.remove(course);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    public void printReport() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Grades: ");
        for (String course : grades.keySet()) {
            System.out.println(course + ": " + grades.get(course));
        }
        System.out.println("GPA: " + calculateGPA());
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String id, String name) {
        students.add(new Student(id, name));
    }

    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void generateReport(String id) {
        Student student = findStudent(id);
        if (student != null) {
            student.printReport();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void listAllStudents() {
        for (Student student : students) {
            student.printReport();
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add, remove, addGrade, removeGrade, report, list, exit): ");
            command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }

            switch (command) {
                case "add":
                    System.out.println("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();
                    sms.addStudent(id, name);
                    break;
                case "remove":
                    System.out.println("Enter student ID: ");
                    id = scanner.nextLine();
                    sms.removeStudent(id);
                    break;
                case "addGrade":
                    System.out.println("Enter student ID: ");
                    id = scanner.nextLine();
                    Student student = sms.findStudent(id);
                    if (student != null) {
                        System.out.println("Enter course name: ");
                        String course = scanner.nextLine();
                        System.out.println("Enter grade: ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        student.addGrade(course, grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "removeGrade":
                    System.out.println("Enter student ID: ");
                    id = scanner.nextLine();
                    student = sms.findStudent(id);
                    if (student != null) {
                        System.out.println("Enter course name: ");
                        String course = scanner.nextLine();
                        student.removeGrade(course);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "report":
                    System.out.println("Enter student ID: ");
                    id = scanner.nextLine();
                    sms.generateReport(id);
                    break;
                case "list":
                    sms.listAllStudents();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        scanner.close();
    }
}