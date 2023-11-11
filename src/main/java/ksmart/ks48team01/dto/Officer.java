package ksmart.ks48team01.dto;

public class Officer {

    private String officerId;
    private String userId;
    private String officerUserName;
    private String districtDepCode;
    private String departmentCode;
    private String officerCert;
    private String workStartDate;
    private String officerAccountStat;
    private String officerRecentLogin;
    private String districtDepName;

    public String getDistrictDepName() {
        return districtDepName;
    }

    public void setDistrictDepName(String districtDepName) {
        this.districtDepName = districtDepName;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOfficerUserName() {
        return officerUserName;
    }

    public void setOfficerUserName(String officerUserName) {
        this.officerUserName = officerUserName;
    }

    public String getDistrictDepCode() {
        return districtDepCode;
    }

    public void setDistrictDepCode(String districtDepCode) {
        this.districtDepCode = districtDepCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getOfficerCert() {
        return officerCert;
    }

    public void setOfficerCert(String officerCert) {
        this.officerCert = officerCert;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getOfficerAccountStat() {
        return officerAccountStat;
    }

    public void setOfficerAccountStat(String officerAccountStat) {
        this.officerAccountStat = officerAccountStat;
    }

    public String getOfficerRecentLogin() {
        return officerRecentLogin;
    }

    public void setOfficerRecentLogin(String officerRecentLogin) {
        this.officerRecentLogin = officerRecentLogin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Officer{");
        sb.append("officerId='").append(officerId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", officerUserName='").append(officerUserName).append('\'');
        sb.append(", districtDepCode='").append(districtDepCode).append('\'');
        sb.append(", departmentCode='").append(departmentCode).append('\'');
        sb.append(", officerCert='").append(officerCert).append('\'');
        sb.append(", workStartDate='").append(workStartDate).append('\'');
        sb.append(", officerAccountStat='").append(officerAccountStat).append('\'');
        sb.append(", officerRecentLogin='").append(officerRecentLogin).append('\'');
        sb.append(", districtDepName='").append(districtDepName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
