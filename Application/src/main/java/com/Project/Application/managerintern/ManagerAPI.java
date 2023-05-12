package com.Project.Application.managerintern;

import com.Project.Application.ExceptionHandler.UserNotFoundEx;
import com.Project.Application.Calculator.GetOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/manager")
class ManagerAPI {
    @Autowired
    private ManagerRepo managerRepo;

    @GetMapping("/x")
    @ResponseBody
    @Cacheable(value = "ManagerDeets", key = "#id")
    public String getManagerName(@RequestParam int id) throws UserNotFoundEx {
        System.out.println("getManager request");
        Optional<Manager> m = managerRepo.findById(id);
        if (m.isPresent()) {
            String fname = m.get().getFname();
            String lname = m.get().getLname();
            return (fname + " " + lname);
        } else {
            throw new UserNotFoundEx("Manager id: " + id + " not present", id);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
        Manager m = new Manager();
        m.setFname(manager.getFname());
        m.setLname(manager.getLname());
        m.setEmail(manager.getEmail());

        managerRepo.save(m);
        return new ResponseEntity<>(manager, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Manager> deleteManager(@RequestParam int id) {
        Optional<Manager> manager = managerRepo.findById(id);
        if (manager.isPresent()) {
            managerRepo.deleteById(id);
            return new ResponseEntity<>(manager.get(), HttpStatus.ACCEPTED);
        } else throw new UserNotFoundEx("Manager id: " + id + " not present", id);

    }

    @GetMapping("/calc")
    @ResponseBody
    public int calculate(@RequestParam String operator) {
        List<Integer> numbers = Arrays.asList(2, 3, 4);
        GetOperation evaluator = new GetOperation(operator);
        return evaluator.getResult(numbers);
    }

    @Autowired
    private CacheImpl cacheService;

    @GetMapping("/email")
    @ResponseBody
    public ResponseEntity<Manager> email(@RequestParam int id) {
        return new ResponseEntity<>(cacheService.getManager(id), HttpStatus.ACCEPTED);
    }

}
