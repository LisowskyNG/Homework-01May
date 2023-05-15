package pro.sky.Homework01May;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Employee min(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Collection<Employee> allByDebt(int dept) {
        return employeeService.getEmployees()
                .stream()
                .filter(e -> e.getDepartment() == dept)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> all() {
        return employeeService.getEmployees()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
