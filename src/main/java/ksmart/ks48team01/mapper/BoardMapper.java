package ksmart.ks48team01.mapper;

import ksmart.ks48team01.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시판 수정
    public String modifyBoardContents(Board board);

    //게시판 목록 조회
    public List<Board> getBoardList();
}
