package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/staff")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("people", employeeService.getAll());
        return "all";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable String id, Model model) {
        model.addAttribute("people", employeeService.getById(Integer.parseInt(id)));
        return "all";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", employeeService.getById(id));
        return "edit";
    }

    @PostMapping
    public String save(@Valid Employee employee,
                       BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "staff/new";
        employeeService.save(employee);
        return "redirect:/staff";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("person") @Valid Employee employee,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "staff/edit";
        employeeService.update(id, employee);
        return "redirect:/staff";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        employeeService.delete(Integer.parseInt(id));
        return "redirect:/staff";
    }
}
