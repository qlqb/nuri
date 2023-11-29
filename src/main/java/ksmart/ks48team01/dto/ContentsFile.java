package ksmart.ks48team01.dto;

public class ContentsFile {
    private String fileCode;
    private String ContentsId;
    private String userId;
    private String fileNumber;
    private String fileName;
    private long fileSize;
    private String fileExt;
    private String filePath;
    private String fileDate;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getContentsId() {
        return ContentsId;
    }

    public void setContentsId(String contentsId) {
        ContentsId = contentsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContentsFile{");
        sb.append("fileCode='").append(fileCode).append('\'');
        sb.append(", ContentsId='").append(ContentsId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", fileNumber='").append(fileNumber).append('\'');
        sb.append(", fileName='").append(fileName).append('\'');
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileExt='").append(fileExt).append('\'');
        sb.append(", filePath='").append(filePath).append('\'');
        sb.append(", fileDate='").append(fileDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
