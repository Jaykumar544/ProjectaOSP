package com.biit.controller;

import com.biit.entities.Employee;
import com.biit.entities.User;
import com.biit.repositories.EmployeeRepository;
import com.biit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @RequestMapping(value="/EmployeeLogin")
    public String employeeLogin()
    {
        return "EmployeeLogin";
    }


    @RequestMapping("/EmployeeSignup")
    public String employeeSignup()
    {
        return "EmployeeSignup";
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/doEmployeeSignup")
    public String doSignup(@ModelAttribute Employee employee)
    {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return "EmployeeSignup";
    }

    @RequestMapping("/employeesReport")
    public ModelAndView employeesReport()
    {
        List<Employee> employees = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees",employees);
        modelAndView.setViewName("employeesReport");
        return  modelAndView;
    }

    @RequestMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable int id)
    {
        Optional<Employee> optionalUser=employeeRepository.findById(id);
        if(optionalUser.isPresent())
            employeeRepository.delete(optionalUser.get());
        else
            System.out.println("Employee not found.");
        return employeesReport();
    }

    @RequestMapping("/employeeUpdate/{id}")
    public ModelAndView employeeUpdate(@PathVariable int id)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeeUpdate");
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent())
        {
            Employee employee = optionalEmployee.get();
            modelAndView.addObject("employeeId",employee.getId());
            modelAndView.addObject("employeeName",employee.getName());
            modelAndView.addObject("employeeEmail",employee.getEmail());
            modelAndView.addObject("employeeSalary",employee.getSalary());
        }
        else
        {
            System.out.println("employee not found.");
        }
        return modelAndView;
    }

    @RequestMapping("/employeeUpdateProcess/{id}")
    public ModelAndView userUpdateProcess(@PathVariable int id, @ModelAttribute Employee employee)
    {
        employee.setId(id);
        Employee dbEmployee = employeeRepository.findById(id).get();

        if(employee.getPassword().isEmpty())
        {
            employee.setPassword(dbEmployee.getPassword());
        }
        else
        {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        }
        employeeRepository.save(employee);
        return employeesReport();
    }
}
