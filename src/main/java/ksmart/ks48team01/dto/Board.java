package ksmart.ks48team01.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Board {
    private String boardCode;
    private String boardCateCode;
    private String boardWritingTitle;
    private String boardWritingContents;
    private String boardFileLink;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String boardRegDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String boardUpdateDate;

    //user DTO에서 가져오는 정보
    private User userInfo;

    private String userId;

    //BoardCateGory DTO에서 가져오는 정보
    private BoardCategory boardCategory;
    private String boardCateName;

    public BoardCategory getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(BoardCategory boardCategory) {
        this.boardCategory = boardCategory;
    }

    public String getBoardCateName() {
        return boardCateName;
    }

    public void setBoardCateName(String boardCateName) {
        this.boardCateName = boardCateName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public String getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(String boardCode) {
        this.boardCode = boardCode;
    }

    public String getBoardCateCode() {
        return boardCateCode;
    }

    public void setBoardCateCode(String boardCateCode) {
        this.boardCateCode = boardCateCode;
    }

    public String getBoardWritingTitle() {
        return boardWritingTitle;
    }

    public void setBoardWritingTitle(String boardWritingTitle) {
        this.boardWritingTitle = boardWritingTitle;
    }

    public String getBoardWritingContents() {
        return boardWritingContents;
    }

    public void setBoardWritingContents(String boardWritingContents) {
        this.boardWritingContents = boardWritingContents;
    }

    public String getBoardFileLink() {
        return boardFileLink;
    }

    public void setBoardFileLink(String boardFileLink) {
        this.boardFileLink = boardFileLink;
    }

    public String getBoardRegDate() {
        return boardRegDate;
    }

    public void setBoardRegDate(String boardRegDate) {
        this.boardRegDate = boardRegDate;
    }

    public String getBoardUpdateDate() {
        return boardUpdateDate;
    }

    public void setBoardUpdateDate(String boardUpdateDate) {
        this.boardUpdateDate = boardUpdateDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Board{");
        sb.append("boardCode='").append(boardCode).append('\'');
        sb.append(", boardCateCode='").append(boardCateCode).append('\'');
        sb.append(", boardWritingTitle='").append(boardWritingTitle).append('\'');
        sb.append(", boardWritingContents='").append(boardWritingContents).append('\'');
        sb.append(", boardFileLink='").append(boardFileLink).append('\'');
        sb.append(", boardRegDate='").append(boardRegDate).append('\'');
        sb.append(", boardUpdateDate='").append(boardUpdateDate).append('\'');
        sb.append(", userInfo=").append(userInfo);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", boardCategory=").append(boardCategory);
        sb.append(", boardCateName='").append(boardCateName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

