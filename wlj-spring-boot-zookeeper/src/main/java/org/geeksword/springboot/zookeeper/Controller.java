package org.geeksword.springboot.zookeeper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/get")
    public Object get(String id){
        System.out.println(id);
        return new Object();
    }

}
