package com.sealedclasses;

record HRManager(String employeeId, int salary) implements Employee {

    public static void main(String... args)
    {
        HRManager hrManager = new HRManager("1100-09", 12000);
        System.out.println(hrManager.getEmployeeNumber());
        System.out.println(hrManager.getSalary());
    }

    @Override
    public int getSalary()
    {
        return salary;
    }

    @Override
    public String getEmployeeNumber()
    {
        return employeeId;
    }
}

public sealed interface Employee permits HRManager
{
    int getSalary();

    String getEmployeeNumber();
}
