package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SchoolController {
//Les 2 lignes vont ensembles pour lier le controller avec entity 
    @Autowired
    SchoolRepository schoolRepo;
    
    @GetMapping("/school")
    public String getSchool(Model model,
                            @RequestParam(required = false) Long id) {

        // TODO : find one school by id
        School school = new School();
    if (id != null) {
        Optional<School> optionalSchool = schoolRepo.findById(id);
        if (optionalSchool.isPresent()) {
            school = optionalSchool.get();
        }
    }
    model.addAttribute("school", school);

        return "school";
    }
//Attention au nom des routes: il faut regarder dans school.html pour avoir les liens
    @GetMapping("/schools")
    public String getAll(Model model) {

        // TODO : find all schools
        model.addAttribute("schools", schoolRepo.findAll());

        return "schools";
    }


    @PostMapping("/school")
    public String postSchool(@ModelAttribute School school) {

        // TODO : create or update a school
            schoolRepo.save(school);
            return "redirect:/schools";
    }
    


    @GetMapping("/school/delete")
    public String deleteSchool(@RequestParam Long id) {

        // TODO : delete a school
        schoolRepo.deleteById(id);

        return "redirect:/schools";
    }
}
