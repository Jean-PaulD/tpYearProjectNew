package com.mycompany.tpnew.api;

import com.mycompany.tpnew.domain.AccountInfo;
import com.mycompany.tpnew.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 5/24/15.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private AccountService service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/accountInfo",method = RequestMethod.GET)
    public AccountInfo getCourse(){
        AccountInfo acc = new AccountInfo.Builder("user1")
                .dateCreated("11th")
                .password("xxx")
                .build();

        return acc;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<AccountInfo> getCourses(){
        return service.getAccountInfo();
    }

}
