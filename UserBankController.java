package com.example.userbank.demo.Controllers;

import com.example.userbank.demo.Services.UserBankService;
import com.example.userbank.demo.dao.models.Bank;
import com.example.userbank.demo.dao.models.User;
import com.example.userbank.demo.dto.BankDTO;
import com.example.userbank.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping(value = "/userbank")
public class UserBankController {
@Autowired
    private UserBankService userBankService;

    @GetMapping(value = "/user")
    public @ResponseBody
    List<UserDTO> getUserUser()   {return userBankService.listuser(); }

    @PostMapping(value = "/user")
    public @ResponseBody String createUser(@RequestBody UserDTO userDTO){
        userBankService.createUser(userDTO);
       return "ok";
    }

    @PutMapping(value = "/user")
    public @ResponseBody String udpateUser(@RequestBody UserDTO userDTO)
    {
        userBankService.updateUser(userDTO);
        return "Ok";
    }

    @DeleteMapping(value = "/user/{id}")
    public @ResponseBody String deleteUser(@PathVariable(value = "id") Long id) {
        userBankService.deleteUser(id);
        return "OK";
    }
    @GetMapping(value = "/bank")
    public @ResponseBody
    List<BankDTO> getUserBank(){return userBankService.listbank(); }

    @PostMapping(value = "/bank")
    public @ResponseBody String createBank(@RequestBody BankDTO bankDTO)
    {
        userBankService.addBank(bankDTO);
        return "ok";
    }
    @PutMapping(value = "/bank")
    public @ResponseBody String udpateBank(@RequestBody BankDTO bankDTO)
    {
        userBankService.updateBank(bankDTO);
        return "ok";
    }
    @DeleteMapping(value = "bank/{id}")
    public @ResponseBody String deleteBank(@PathVariable(value = "id") Long id ){
         userBankService.deleteBank(id);
        return "ok";
    }

}
