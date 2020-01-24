package com.michael.schoolWebAppwithmongo.controller;

import com.michael.schoolWebAppwithmongo.documents.Administrator;
import com.michael.schoolWebAppwithmongo.documents.Student;
import com.michael.schoolWebAppwithmongo.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    private StudentRepository repository;

    public StudentController(StudentRepository repository){
        this.repository = repository;
    }

    @ModelAttribute("students")
    public Iterable<Student> populateStudents(){

        return repository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/students")
    public String  getStudents(){
       return "students";

    }

    /*@DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id){
        repository.deleteById(id);
        return "students";
    }*/

    @RequestMapping(value = "/students", method={RequestMethod.POST,RequestMethod.PUT})
    public String saveStudent(@Valid @RequestBody Student std){

        Student repoStd = repository.findById(std.getId()).get();

        if(repoStd != null){
            repoStd.setCourse(std.getCourse());
            repoStd.setYearOfStudy(std.getYearOfStudy());
            repoStd.setFirstName(std.getFirstName());
            repoStd.setLastName(std.getLastName());
            std = repoStd;
        }
        repository.save(std);
        return "students";
    }

    @RequestMapping(value = "/students", params ={"delete"})
    public String deleteStudent(@RequestParam(value="delete",required = false) String id){
        System.out.println(id);
        repository.deleteById(id);
        return "redirect:/students";
    }

}
