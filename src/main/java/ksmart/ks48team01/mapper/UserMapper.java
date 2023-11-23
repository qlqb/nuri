package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 관리자 페이지 전체 회원 조회
    List<User> getUserList();

    // 회원의 로그인
    Boolean getUserIdCheck(String userId);

    // 회원의 아이디 찾기
    String findMyId(String userName, String userEmail);

    // 회원의 비밀번호 초기화를 위한 회원확인
    int findMyPw(String userId, String userContact);

    // 등록하는 비밀번호의 중복검사
    int isExistingPw (String userId, String resetPw);

    // 회원의 비밀번호 초기화
    void resetMyPw(String userId, String resetPw);

    // 관리자 페이지 특정 회원 상세 조회
    User getSpecificUserList(String userId);
    
    // 관리자 등록
    void adminRegister(User user);
    
    // 관리자의 회원정보 수정
    void updateUserByAdmin(User user);
    
    // 사용자 등록
    int memberRegister(User user);

    // 공무원 등록
    int officerUserRegister(User user);

    // 가맹점 등록
    int storeUserRegister(User user);

    // 유저 검색
    List<User> userSearchList(String searchKey, String searchValue);
    
    
    // 사용자 문화누리카드 등록정보 삭제
    void userCardInfoDelete(String deleteTarget);
    // 회원의 등록한 이미지 파일 삭제
    void userFileDelete(String deleteTarget);
    // 게시한 글 정보 삭제
    void userBoardDelete(String deleteTarget);
    // 회원의 결제정보 삭제
    void userPaymentInfoDelete(String deleteTarget);
    
}
