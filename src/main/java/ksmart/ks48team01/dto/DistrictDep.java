package ksmart.ks48team01.dto;

/**
 * District의 행정기관(Department)의 DTO
 */
public class DistrictDep {

    private String districtDepCode;
    private int regionCode;
    private int districtCode;
    private String districtDepName;

    public String getDistrictDepCode() {
        return districtDepCode;
    }

    public void setDistrictDepCode(String districtDepCode) {
        this.districtDepCode = districtDepCode;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictDepName() {
        return districtDepName;
    }

    public void setDistrictDepName(String districtDepName) {
        this.districtDepName = districtDepName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DistrictDep{");
        sb.append("districtDepCode='").append(districtDepCode).append('\'');
        sb.append(", regionCode=").append(regionCode);
        sb.append(", districtCode=").append(districtCode);
        sb.append(", districtDepName='").append(districtDepName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
