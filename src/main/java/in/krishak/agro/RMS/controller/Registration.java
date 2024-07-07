package in.krishak.agro.RMS.controller;

import in.krishak.agro.RMS.dto.AdminUserInfo;
import in.krishak.agro.RMS.dto.UserInfo;
import in.krishak.agro.RMS.mapper.UserMapper;
import in.krishak.agro.RMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Registration {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/info/user")
    public ResponseEntity<UserInfo> fetchUserInfo(@RequestParam String phoneNumber) throws Exception {
        UserInfo userInfo = userMapper.toUserInfo(userService.fetchUserDetail(phoneNumber));
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserInfo> signIn(@RequestBody UserInfo userInfo) throws Exception {
        userService.signIn(userInfo);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody AdminUserInfo userInfo) throws Exception {
        userService.signUpAdminUser(userInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/log-in")
    public ResponseEntity<Void> logIn(@RequestBody AdminUserInfo adminUserInfo) throws Exception {
        userService.logIn(adminUserInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
