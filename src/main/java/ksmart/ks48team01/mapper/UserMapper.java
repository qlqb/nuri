package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * 관리자 페이지 전체 회원 조회
     * @return
     */
    public List<User> getUserList();

    /**
     * 관리자 페이지 특정 회원 상세 조회
     * @param userId
     * @return
     */
    public User getSpecificUserList(String userId);


}
