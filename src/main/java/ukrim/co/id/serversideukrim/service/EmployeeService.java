/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ukrim.co.id.serversideukrim.model.Employee;
import ukrim.co.id.serversideukrim.model.Role;
import ukrim.co.id.serversideukrim.repository.EmployeeRepository;

/**
 *
 * @author MSI-JO
 */
@Service
@AllArgsConstructor
public class EmployeeService  {
    
    private EmployeeRepository employeeRepository;
    private RoleService roleService;
    
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    
    public Employee getById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee id not found"
                ));
    }
    
    public Employee create(Employee employee){
        // Set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1L));
        employee.getUser().setRoles(roles);
        
        // Set Employee in User
        employee.getUser().setEmployee(employee);
        
        return employeeRepository.save(employee);
    }
    
    public Employee update(Long id, Employee employee){
        getById(id);
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    
    public Employee delete(Long id){
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}
