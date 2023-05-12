package com.Project.Application.managerintern;

import com.Project.Application.ExceptionHandler.UserNotFoundEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CacheImpl {
    @Autowired
    private ManagerRepo managerRepo;
    private Map<Integer, Manager> cacheMap = new LinkedHashMap<>(5);

    public Manager getManager(int id) {
        Manager t = cacheMap.get(id);
        if(t != null){
            cacheMap.remove(t);
            cacheMap.put(id, t);
            System.out.println("Retrieved using cache");
            return cacheMap.get(id);
        }

        Optional<Manager> m = managerRepo.findById(id);
        if(m.isPresent()) {
            for(Map.Entry<Integer, Manager> x: cacheMap.entrySet()){
                cacheMap.remove(x.getKey());
                break;
            }
            System.out.println("Putting in cache and Retrieving");
            cacheMap.put(id, m.get());
            return cacheMap.get(id);
        }
        else
            throw new UserNotFoundEx("Manager id: " + id + " not present", id);
    }
}
