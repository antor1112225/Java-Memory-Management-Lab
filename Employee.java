import java.util.Scanner;

/**
 * Java Lab Practice Problem — Intermediate Level (3 Points)
 * Title: Demonstrating Stack Frames, Heap Objects, and Inner Classes
 *
 * Concepts Demonstrated:
 * - Stack Frames: Method calls (main, display, show) each create a stack frame.
 * - Heap Memory: Objects (Employee, Report) and instance fields (salary) live in Heap.
 * - Local Variables: Variables defined in methods (bonus) live on the thread's Stack frame.
 * - Local Inner Class: Report is defined inside display(), instantiated on the Heap,
 *   and has access to enclosing instance members.
 */
public class Employee {

    // Instance variable (stored in Heap memory inside Employee object)
    private int salary;

    // Constructor to initialize instance variable
    public Employee(int salary) {
        this.salary = salary;
    }

    // Default constructor
    public Employee() {
        this.salary = 30000;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Overloaded display method using default bonus value (5000)
     */
    public void display() {
        display(5000);
    }

    /**
     * Instance method display()
     * Demonstrates local variable and local inner class Report
     */
    public void display(int inputBonus) {
        // Local variable declared inside display() (stored in display()'s Stack frame)
        int bonus = inputBonus;

        System.out.println("\nInside display() Method:");
        System.out.println("Salary (Instance Variable): " + this.salary);
        System.out.println("Bonus (Local Variable): " + bonus);

        // Local Inner Class named Report
        class Report {
            // Method inside the local inner class
            public void show() {
                // Accessing enclosing class instance variable 'salary'
                System.out.println("Report: Employee salary is " + salary);
            }
        }

        // Creating Report object (allocated on the Heap; reference lives on Stack)
        Report report = new Report();

        System.out.println("\nReport Object Created");
        System.out.println("Report Identity Hash Code: " + System.identityHashCode(report));

        // Calling show() method (creates its own execution stack frame)
        report.show();

        // Print memory architecture summary
        printMemoryConcept();
    }

    /**
     * Helper method to print the memory concept explanation
     */
    public static void printMemoryConcept() {
        System.out.println("\nMemory Concept:");
        System.out.println("Employee object -> Heap");
        System.out.println("Report object -> Heap");
        System.out.println("salary -> Instance field");
        System.out.println("bonus -> Local variable in display()");
        System.out.println("show() -> Executes in its own method frame");
    }

    public static void main(String[] args) {
        int salary = 30000;
        int bonus = 5000;

        // Scanner to allow dynamic input while cleanly falling back to sample defaults
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter salary: ");
            if (scanner.hasNextInt()) {
                salary = scanner.nextInt();
            }
            System.out.print("Enter bonus: ");
            if (scanner.hasNextInt()) {
                bonus = scanner.nextInt();
            }
        } catch (Exception e) {
            salary = 30000;
            bonus = 5000;
        }

        // Creating Employee object in Heap memory; reference 'emp' resides in main()'s Stack frame
        Employee emp = new Employee(salary);

        System.out.println("\nEmployee Object Created");
        System.out.println("Employee Identity Hash Code: " + System.identityHashCode(emp));

        // Call display method passing bonus
        emp.display(bonus);

        scanner.close();
    }
}
