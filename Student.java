import java.util.Scanner;

/**
 * Java Lab Practice Problem (1 Point / 3 Points Distribution)
 * Problem: Demonstrate Stack and Heap Memory in Java
 *
 * Concepts Demonstrated:
 * - Stack Memory: Stores primitive local variables (marks) and reference variables (student).
 * - Heap Memory: Stores dynamically allocated objects (Student object) and their instance variables (age).
 * - System.identityHashCode(): Returns the default identity hash code for the object in heap memory.
 */
public class Student {

    // Instance variable (stored in Heap memory as part of the Student object)
    private int age;

    // Constructor to initialize instance variable
    public Student(int age) {
        this.age = age;
    }

    // Default constructor
    public Student() {
        this.age = 20;
    }

    // Getter and Setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Overloaded display method using default sample marks
     */
    public void display() {
        int marks = 85; // Local variable declared inside display() (stored in Stack frame)
        printDetails(marks);
    }

    /**
     * Display method accepting custom marks
     */
    public void display(int inputMarks) {
        // Local variable declared inside method (stored in the current thread's Stack frame)
        int marks = inputMarks;
        printDetails(marks);
    }

    private void printDetails(int marks) {
        // Displaying instance variable (Heap) and local variable (Stack)
        System.out.println("Instance Variable (age): " + this.age);
        System.out.println("Local Variable (marks): " + marks);
    }

    public static void main(String[] args) {
        int inputAge = 20;
        int inputMarks = 85;

        // Try reading user input if provided via terminal / stdin
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Age: ");
            if (scanner.hasNextInt()) {
                inputAge = scanner.nextInt();
            }
            System.out.print("Marks: ");
            if (scanner.hasNextInt()) {
                inputMarks = scanner.nextInt();
            }
        } catch (Exception e) {
            // Fall back to sample input
            inputAge = 20;
            inputMarks = 85;
        }

        // Creating Student object in Heap memory; reference 'student' resides in Stack memory
        Student student = new Student(inputAge);

        System.out.println("\nStudent Object Created");
        // Display object identity using System.identityHashCode()
        System.out.println("Object Identity Hash Code: " + System.identityHashCode(student));

        // Call display() to show instance variable (age) and local variable (marks)
        student.display(inputMarks);

        scanner.close();
    }
}
