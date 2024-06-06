class Manager extends Employee {
    public Manager(String name, String birthDate, String position, String department) {
        super(name, birthDate, position, department);
    }

    @Override
    protected double setSalary(String position) {
        return 20000000;
    }
}
