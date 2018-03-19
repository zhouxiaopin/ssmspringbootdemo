package com.gzticc.ssmspringbootdemo.web;

import com.gzticc.ssmspringbootdemo.pojo.User;
import com.gzticc.ssmspringbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
//@RestController=@Controller+@ResponseBody
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> modelMap = new HashMap<>();
        List<User> users = userService.queryUser();
        modelMap.put("data", users);
        return modelMap;
    }
    @GetMapping("/queryByPk")
    public Map<String, Object> queryByPk(Long userId) {
        Map<String, Object> modelMap = new HashMap<>();
        User user = userService.queryUserById(userId);
        modelMap.put("data", user);
        return modelMap;
    }
    @PostMapping("/add")
    public Map<String, Object> add(User user) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = userService.addUser(user);
        modelMap.put("success", flag);
        return modelMap;
    }
    @PostMapping("/update")
    public Map<String, Object> update(User user) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = userService.updateUser(user);
        modelMap.put("success", flag);
        return modelMap;
    }
    @PostMapping("/delete")
    public Map<String, Object> delete(Long userId) {
        Map<String, Object> modelMap = new HashMap<>();
        boolean flag = userService.deleteUser(userId);
        modelMap.put("success", flag);
        return modelMap;
    }


}
