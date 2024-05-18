import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double hourlyRate;
    private double hoursWorked;
    private double salary;
    private double taxRate;

    public Employee(String name, int id, double hourlyRate, double salary, double taxRate) {
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.taxRate = taxRate;
        this.hoursWorked = 0.0;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateHourlyPay() {
        return hourlyRate * hoursWorked;
    }

    public double calculateMonthlySalary() {
        return salary;
    }

    public double calculateTax(double grossPay) {
        return grossPay * taxRate / 100;
    }

    public double calculateNetPay(double grossPay) {
        return grossPay - calculateTax(grossPay);
    }

    public void printPayStub() {
        double grossPay;
        if (salary > 0) {
            grossPay = calculateMonthlySalary();
        } else {
            grossPay = calculateHourlyPay();
        }
        double tax = calculateTax(grossPay);
        double netPay = calculateNetPay(grossPay);

        System.out.println("Pay Stub for Employee: " + name);
        System.out.println("Employee ID: " + id);
        if (salary > 0) {
            System.out.println("Monthly Salary: $" + salary);
        } else {
            System.out.println("Hourly Rate: $" + hourlyRate);
            System.out.println("Hours Worked: " + hoursWorked);
        }
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Tax Deducted: $" + tax);
        System.out.println("Net Pay: $" + netPay);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee ID:");
        int id = scanner.nextInt();

        System.out.println("Enter hourly rate (enter 0 if salaried):");
        double hourlyRate = scanner.nextDouble();

        System.out.println("Enter monthly salary (enter 0 if hourly):");
        double salary = scanner.nextDouble();

        System.out.println("Enter tax rate (%):");
        double taxRate = scanner.nextDouble();

        Employee employee = new Employee(name, id, hourlyRate, salary, taxRate);

        if (salary == 0) {
            System.out.println("Enter hours worked:");
            double hoursWorked = scanner.nextDouble();
            employee.setHoursWorked(hoursWorked);
        }

        System.out.println("\nPay Stub:");
        employee.printPayStub();

        scanner.close();
    }
}