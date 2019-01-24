package com.springboot.controller;

import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.entities.Department;
import com.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ProjectName: springboot-web1
 * @Package: com.springboot.controller
 * @ClassName: EmployeeController
 * @Author: gnnt
 * @Date: 2019/1/24 10:52
 * @Version: 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
