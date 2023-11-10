package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService (UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();

        return userList;
    }

    public void adminRegister (User user) {
        userMapper.adminRegister(user);
    }

    public User getSpecificUserList(String userId) {
        User specificUserList = userMapper.getSpecificUserList(userId);

        return specificUserList;
    }

    public void userUpdateByAdmin(User user) {
        userMapper.userUpdateByAdmin(user);
    }

    public void userDeleteByAdmin(String deleteTarget, int targetLevel) {

        switch (targetLevel) {
            case 4 :
            userMapper.userCardInfoDelete(deleteTarget);
            break;
            case 3 :

        }
        userMapper.userFileDelete(deleteTarget);
        userMapper.userBoardDelete(deleteTarget);
        userMapper.userPaymentInfoDelete(deleteTarget);

    }
}
