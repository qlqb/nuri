package ksmart.ks48team01.dto;

public class Department {

    private String departmentCode;
    private String departmentName;
    private String departmentDivName;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDivName() {
        return departmentDivName;
    }

    public void setDepartmentDivName(String departmentDivName) {
        this.departmentDivName = departmentDivName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("departmentCode='").append(departmentCode).append('\'');
        sb.append(", departmentName='").append(departmentName).append('\'');
        sb.append(", departmentDivName='").append(departmentDivName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
