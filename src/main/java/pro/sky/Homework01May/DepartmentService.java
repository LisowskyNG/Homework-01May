package pro.sky.Homework01May;

import org.springframework.stereotype.Service;

import static java.util.Arrays.stream;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max(int dept) {
        employeeService.getEmployees();
        .stream()
                .filter


        return null;
    }




}
