package com.michael.schoolWebAppwithmongo.controller;

import com.michael.schoolWebAppwithmongo.documents.Student;
import com.michael.schoolWebAppwithmongo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class StudentController {

    private StudentRepository repository;

    private Logger log = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentRepository repository){
        this.repository = repository;
    }

    @ModelAttribute("students")
    public Iterable<Student> populateStudents(){

        return repository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

    /*@GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }*/

    @GetMapping("/students")
    public String  getStudents(){
       return "students";

    }

    @GetMapping(value="/addStudent")
    public String  getAddStudent(Student student){

        return "addStudent";
    }

    @RequestMapping(value="/students", params = {"edit"})
    public String editStudent(Model model, @RequestParam(value="edit", required = false) String id ){
        Optional<Student> std = repository.findById(id);
        if(std.isPresent()){
            model.addAttribute("student", std);
            return "/addStudent";
        }
        return "/addStudent";
    }




    /*@DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id){
        repository.deleteById(id);
        return "students";
    }*/

    @RequestMapping(value = "/addStudent", params = {"saveStudent"})
    public String saveStudent(Student std, final BindingResult result){

        if(result.hasErrors()){
            return "/addStudent";
        }

        Optional<Student> repoStdOp = repository.findById(std.getId());

        if(repoStdOp.isPresent()){
            Student repoStd = repoStdOp.get();


            repoStd.setCourse(std.getCourse());
            repoStd.setYearOfStudy(std.getYearOfStudy());
            repoStd.setFirstName(std.getFirstName());
            repoStd.setLastName(std.getLastName());
            std = repoStd;
        }
        repository.save(std);
        return "redirect:/students";
    }


    @RequestMapping(value = "/students", params ={"delete"})
    public String deleteStudent(@RequestParam(value="delete",required = false) String id){
        System.out.println(id);
        repository.deleteById(id);
        return "redirect:/students";
    }

}
