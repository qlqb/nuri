package ksmart.ks48team01.dto;

public class BoardCategory {
    private String boardCateCode;
    private String boardCateName;

    public String getBoardCateCode() {
        return boardCateCode;
    }

    public void setBoardCateCode(String boardCateCode) {
        this.boardCateCode = boardCateCode;
    }

    public String getBoardCateName() {
        return boardCateName;
    }

    public void setBoardCateName(String boardCateName) {
        this.boardCateName = boardCateName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BoardCategory{");
        sb.append("boardCateCode='").append(boardCateCode).append('\'');
        sb.append(", boardCateName='").append(boardCateName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
