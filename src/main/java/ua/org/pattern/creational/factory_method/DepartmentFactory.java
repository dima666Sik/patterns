package ua.org.pattern.creational.factory_method;

import lombok.Getter;
import lombok.Setter;

class Main{
    public static void main(String[] args) {
        Department department = new ITDepartment();
        department.hireEmployee(11L, 1000, 100);
    }
}

abstract class Department {
    protected abstract Employee createEmployee(Long id);

    public void hireEmployee(Long id, int salary, int bonus) {
        Employee employee = createEmployee(id);
        employee.setSalary(salary);
        employee.setBonus(bonus);
        System.out.println(employee);
    }
}

@Getter
@Setter
abstract class Employee {
    protected int salary;
    protected int bonus;
}
class Programmer extends Employee {
    private Long id;

    public Programmer(Long id) {
        super();
        this.id = id;
    }
    @Override
    public String toString() {
        return "Programmer{ id=" + id + ", salary="+  super.salary + ", bonus=" + super.bonus + "}";
    }
}

class Accountant extends Employee {
    private Long id;

    public Accountant(Long id) {
        super();
        this.id = id;
    }

    @Override
    public String toString() {
        return "Accountant{ id=" + id + ", salary="+  super.salary + ", bonus=" + super.bonus + "}";
    }
}

class ITDepartment extends Department {
    public Employee createEmployee(Long id) {
        return new Programmer(id);
    }
}

class AccountingDepartment extends Department {
    public Employee createEmployee(Long id) {
        return new Accountant(id);
    }
}