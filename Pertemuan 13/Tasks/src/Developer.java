class Developer extends Employee {
    public Developer(String name, String birthDate, String position, String department) {
        super(name, birthDate, position, department);
    }

    @Override
    protected double setSalary(String position) {
        return 10000000;
    }
}