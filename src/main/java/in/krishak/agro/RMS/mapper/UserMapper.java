package in.krishak.agro.RMS.mapper;

import in.krishak.agro.RMS.dto.UserInfo;
import in.krishak.agro.RMS.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfo toUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(user.getName());
        userInfo.setStatus(user.getStatus());
        userInfo.setPhoneNumber(user.getPhoneNumber());
        userInfo.setAddress(user.getAddress());
        userInfo.setExternalId(user.getExternalId());

        return userInfo;
    }

    public User toUser(UserInfo userInfo) {
        User user = new User();
        user.setName(userInfo.getName());
        user.setStatus(userInfo.getStatus());
        user.setPhoneNumber(userInfo.getPhoneNumber());
        user.setAddress(userInfo.getAddress());
        user.setExternalId(userInfo.getExternalId());


        return user;
    }
}
