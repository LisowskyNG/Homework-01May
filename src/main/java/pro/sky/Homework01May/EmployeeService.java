package pro.sky.Homework01May;

import org.springframework.stereotype.Service;
import pro.sky.Homework01May.exeption.EmployeeAlreadyAddedException;
import pro.sky.Homework01May.exeption.EmployeeNotFoundException;
import pro.sky.Homework01May.exeption.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public static final int MAX_SIZE = 100;

    private final List<Employee> employees = new ArrayList<>(MAX_SIZE);

    public Employee add(String firstName, String lastName) {
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new  EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName) {
        var employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
