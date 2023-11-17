package ksmart.ks48team01.service;

import ksmart.ks48team01.admin.controller.AdminBoardController;
import ksmart.ks48team01.dto.BoardCategory;
import ksmart.ks48team01.mapper.BoardMapper;
import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.User;
import ksmart.ks48team01.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    private static final Logger log = LoggerFactory.getLogger(BoardService.class);

    //DI(의존성 주입)
    private final BoardMapper boardMapper;
    private final UserMapper userMapper;

    //생성자 메서드를 통한 DI
    public BoardService(BoardMapper boardMapper, UserMapper userMapper){
        this.boardMapper = boardMapper;
        this.userMapper = userMapper;
    }

    //게시글 삭제
    public void removeBoardContents(String boardCode){
        boardMapper.removeBoardContents(boardCode);
    }

    //user페이지 카테고리별 게시판 조회
    public List<Board> boardSearchCate(String searchKey){
        List<Board> boardSearchCate = boardMapper.getBoardCateBySearch(searchKey);
        return boardSearchCate;
    }

    //검색어에 따른 회원의 목록조회
    public List<Board> boardSearchList(String searchKey, String searchValue){

        List<Board> boardSearchList = boardMapper.getBoardListBySearch(searchKey, searchValue);

        return boardSearchList;
    }
    //게시판 수정
    public int modifyBoardContents(Board board){
        return boardMapper.modifyBoardContents(board);
    }

    //특정 게시판 조회
    public Board getBoardInfoById(String boardCode) {
        Board boardInfo = boardMapper.getBoardInfoById(boardCode);
        return boardInfo;
    }

    //게시글 등록
    public void boardContentRegist(Board board){
            log.info("상품등록 전{}:", board);
          boardMapper.boardContentRegist(board);
          log.info("상품등록 후{}:", board);
        }

    	/*public int boardContentRegist(Board board) {
		int result = boardMapper.boardContentRegist(board);
		return result;
	}*/

    //게시판 카테고리 조회
    public List<BoardCategory> getBoardCategoryList(){
        List<BoardCategory> boardCategoryList = boardMapper.getBoardCategoryList();

        return boardCategoryList;
    }

    //게시판 목록 조회
    public List<Board> getBoardList(){
        List<Board> boardList = boardMapper.getBoardList();

        return boardList;
    }



}
