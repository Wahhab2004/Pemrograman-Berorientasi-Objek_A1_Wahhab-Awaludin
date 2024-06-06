import java.util.Random;

abstract class Employee {
    protected String name;
    protected String birthDate;
    protected String position;
    protected String department;
    protected String employeeID;
    protected double salary;

    public Employee(String name, String birthDate, String position, String department) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.department = department;
        this.employeeID = generateEmployeeID(department, birthDate);
        this.salary = setSalary(position);
    }

    private String generateEmployeeID(String department, String birthDate) {
        String departmentCode = department.equals("PROD") ? "000PROD" : "000HR";
        int randomNum = new Random().nextInt(9000) + 1000;
        return departmentCode + birthDate + randomNum;
    }

    protected abstract double setSalary(String position);

    public static String[] getDepartments() {
        return new String[]{"PROD", "HR"};
    }

    public String getDetails() {
        return "ID: " + employeeID + ", Name: " + name + ", Birth Date: " + birthDate +
                ", Position: " + position + ", Department: " + department + ", Salary: " + salary;
    }
}

