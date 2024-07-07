package in.krishak.agro.RMS.service;

import in.krishak.agro.RMS.daos.AdminUserRepository;
import in.krishak.agro.RMS.daos.UserRepository;
import in.krishak.agro.RMS.dto.AdminUserInfo;
import in.krishak.agro.RMS.dto.UserInfo;
import in.krishak.agro.RMS.mapper.UserMapper;
import in.krishak.agro.RMS.models.AdminUser;
import in.krishak.agro.RMS.models.User;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private UserMapper userMapper;


    public User fetchUserDetail(String phoneNumber) throws Exception {

        try {
            Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
            if (user.isPresent()) return user.get();

        } catch (Exception e) {
            log.info("Error fetch detail");
            throw new RuntimeException("Not able to fetch user detail");
        }
        throw new RuntimeException("User don't exist");
    }

    public User fetchUserDetailByExternalId(String externalId) throws Exception {

        try {
            Optional<User> user = userRepository.findByExternalId(externalId);
            if (user.isPresent()) return user.get();

        } catch (Exception e) {
            log.info("Error fetch detail");
            throw new RuntimeException("Not able to fetch user detail");
        }
        throw new RuntimeException("User don't exist");
    }

    public void signIn(UserInfo userInfo) throws Exception {

        Optional<User> user = userRepository.findByPhoneNumber(userInfo.getPhoneNumber());

        if (user.isPresent()) {
            throw new RuntimeException("Phone number already exist in system");
        } else {
            User user1 = userMapper.toUser(userInfo);
            userRepository.save(user1);
        }

    }

    public void logIn(AdminUserInfo userInfo) throws Exception {

        Optional<AdminUser> user = adminUserRepository.findByPhoneNumber(userInfo.getPhoneNumber());

        if (user.isEmpty()) {
            throw new RuntimeException("Invalid user detail");
        } else if (!user.get().getPassword().equals(userInfo.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

    }

    public void signUpAdminUser(AdminUserInfo userInfo) throws Exception {
        Optional<AdminUser> user = adminUserRepository.findByPhoneNumber(userInfo.getPhoneNumber());

        if (user.isPresent()) {
            throw new RuntimeException("Phone number already exists in the system for an admin user");
        } else {
            if (!userInfo.getPassword().equals(userInfo.getConfirmPassword())) {
                throw new RuntimeException("Password mismatch");
            }
            adminUserRepository.save(AdminUser.builder()
                            .password(userInfo.getPassword())
                            .externalId(UUID.randomUUID().toString())
                            .phoneNumber(userInfo.getPhoneNumber())
                    .build());
        }

    }
}
