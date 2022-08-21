package com.naskete.manage.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.naskete.manage.entity.User;
import com.naskete.manage.service.BackupService;
import com.naskete.manage.service.UserService;
import com.naskete.manage.util.ResultJson;
import com.naskete.manage.util.Sha256;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @Autowired
    private UserService userService;

    @Autowired
    private BackupService backupService;

    @PostMapping("/login")
    public ResultJson login(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        User user = userService.FindByUsername(username);
        if (user == null) {
            return new ResultJson(400, "user does not exist");
        }
        if (StpUtil.isLogin()) {
            return new ResultJson(200, "you have already login", StpUtil.getTokenInfo().tokenValue);
        }
        if (Sha256.check(password, user.getPassword())) {
            StpUtil.login(user.getUid());
            String token = StpUtil.getTokenInfo().tokenValue;
            return new ResultJson(200, "sign in", token);
        }
        return new ResultJson(400, "wrong username or password");
    }

    @GetMapping("/logout")
    public ResultJson logout(){
        StpUtil.logout();
        return new ResultJson(200, "sign out");
    }

    @PostMapping("/register")
    public ResultJson register(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("telephone") String telephone) {
        User usr = userService.FindByUsername(username);
        if (usr != null && usr.getTelephone().equals(telephone)) {
            return new ResultJson(302, "user already exists");
        }
        String pwd = Sha256.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setTelephone(telephone);
        userService.saveUser(user);
        return new ResultJson(200, "signed in");
    }

    public ResultJson backups() {
        if (backupService.backup()) {
            return new ResultJson(200, "backup database successfully");
        }
        return new ResultJson(400, "backup database failed");
    }
}
