package ksmart.ks48team01.dto;

/**
 * District의 행정기관(Department)의 DTO
 */
public class DistrictDep {

    private int regionCode;
    private int districtCode;
    private String districtDepCode;
    private String regionName;
    private String districtName;
    private String districtDepName;

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

    public String getDistrictDepCode() {
        return districtDepCode;
    }

    public void setDistrictDepCode(String districtDepCode) {
        this.districtDepCode = districtDepCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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
        sb.append("regionCode=").append(regionCode);
        sb.append(", districtCode=").append(districtCode);
        sb.append(", districtDepCode='").append(districtDepCode).append('\'');
        sb.append(", regionName='").append(regionName).append('\'');
        sb.append(", districtName='").append(districtName).append('\'');
        sb.append(", districtDepName='").append(districtDepName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
