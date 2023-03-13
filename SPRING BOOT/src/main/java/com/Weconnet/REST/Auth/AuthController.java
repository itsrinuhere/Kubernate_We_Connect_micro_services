package com.Weconnet.REST.Auth;

import com.Weconnet.REST.Logg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value="auth")
public class AuthController {
    Service service = new Service();
    @RequestMapping(value="create",method= RequestMethod.POST)
    ResponseEntity saveUser(@RequestBody User user){
        Logg.log("create Mapping called");
    return service.saveUser(user);
    }
    @RequestMapping(value="validate",method=RequestMethod.GET)
    ResponseEntity validate(@RequestBody User user){
        Logg.log("validate called");
        return service.verify(user);
    }
    @RequestMapping(value="validate1",method=RequestMethod.GET)
    ResponseEntity validate(@RequestParam("username") String username,@RequestParam("password") String password){
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        return service.verify(u);
    }
    @RequestMapping(value="getAll",method = RequestMethod.GET)
    ResponseEntity<User> getallUser(){
        return new Service().getAlluser();
    }
}
