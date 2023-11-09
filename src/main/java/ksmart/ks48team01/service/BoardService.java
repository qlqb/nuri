package ksmart.ks48team01.service;

import ksmart.ks48team01.mapper.BoardMapper;
import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    //DI(의존성 주입)
    private final BoardMapper boardMapper;
    private final UserMapper userMapper;

    //생성자 메서드를 통한 DI
    public BoardService(BoardMapper boardMapper, UserMapper userMapper){
        this.boardMapper = boardMapper;
        this.userMapper = userMapper;
    }

    //게시판 수정
    public void modifyBoardContents(Board board){
        boardMapper.modifyBoardContents(board);
    }

    //게시판 목록 조회
    public List<Board> getBoardList(){
        List<Board> boardList = boardMapper.getBoardList();

        return boardList;
    }


}
