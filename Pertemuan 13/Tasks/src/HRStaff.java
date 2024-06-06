

class HRStaff extends Employee {
    public HRStaff(String name, String birthDate, String position, String department) {
        super(name, birthDate, position, department);
    }

    @Override
    protected double setSalary(String position) {
        return 5000000;
    }
}
