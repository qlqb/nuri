package ksmart.ks48team01.service;

import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService (UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 회원 전체 리스트
    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();

        return userList;
    }

    public List<User> userSearchList(String searchKey, String searchValue) {

        List<User> userSearchList = userMapper.userSearchList(searchKey, searchValue);

        return userSearchList;
    }

    // 관리자 계정 가입
    public void adminRegister (User user) {
        userMapper.adminRegister(user);
    }
    
    // 사용자 가입
    public void memberRegister(User user) {
        userMapper.memberRegister(user);
    }
    
    
    public Map<String, Object> checkUserInfo(String userId, String userPw) {
        Map<String, Object> loginMap = new HashMap<String, Object>();
        boolean isChecked = false;
        User userInfo = userMapper.getSpecificUserList(userId);
        if(userInfo != null) {
            String userPass = userInfo.getUserPw();
            if(userPass.equals(userPw)) {
                isChecked = true;
                loginMap.put("userLevel", userInfo.getLevelId());
            }
        }

        if(!isChecked) loginMap.put("msg", "일치하는 정보가 없습니다.");

        loginMap.put("isChecked", isChecked);

        return loginMap;
    }
    

    // 특정 회원 조회 및 수정
    public User getSpecificUserList(String userId) {
        User specificUserList = userMapper.getSpecificUserList(userId);

        return specificUserList;
    }

    public void updateUserByAdmin(User user) {
        userMapper.updateUserByAdmin(user);
    }



    
//    //회원 정보 삭제
//    public void userDeleteByAdmin(String deleteTarget, int targetLevel) {
//
//        switch (targetLevel) {
//            case 4 :
//            userMapper.userCardInfoDelete(deleteTarget);
//            break;
//        }
//        userMapper.userFileDelete(deleteTarget);
//        userMapper.userBoardDelete(deleteTarget);
//        userMapper.userPaymentInfoDelete(deleteTarget);
//
//    }
}
