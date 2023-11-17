package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Board;
import ksmart.ks48team01.dto.BoardCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 삭제
    public int removeBoardContents(String boardCode);

    //카테고리로 게시판 조회
    public List<Board> getBoardCateBySearch(String searchKey);

    //검색조건에 따른 게시판목록 조회
    public List<Board> getBoardListBySearch(String searchKey, String searchValue);

    //게시판 수정
    public int modifyBoardContents(Board board);

    //특정 게시판 조회
    public Board getBoardInfoById(String boardCode);

    //게시글 등록
    public int boardContentRegist(Board board);

    //게시판 카테고리 조회
    public List<BoardCategory> getBoardCategoryList();

    //게시판 목록 조회
    public List<Board> getBoardList();
}
