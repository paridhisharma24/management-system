package com.Project.Application.managerintern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/intern")
public class InternAPI {
    @Autowired
    private InternRepo internRepo;
    @GetMapping
    @ResponseBody
    public String getInternName(@RequestParam int id) {
        return internRepo.findById(id).get().getFname();
    }

    @PostMapping
    @ResponseBody
    public Intern addIntern(@RequestParam int id, @RequestParam String fname, @RequestParam String lname)
    {
        Intern intern = new Intern();
        intern.setIid(id);
        intern.setFname(fname);
        intern.setLname(lname);

        internRepo.save(intern);
        return intern;
    }

    @DeleteMapping
    @ResponseBody
    public String deleteIntern(@RequestParam int id)
    {
        Optional<Intern> intern = internRepo.findById(id);
        internRepo.deleteById(id);
        return ("Manager with id " + id + " deleted");
    }
}
