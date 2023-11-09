package ksmart.ks48team01.dto;

import java.util.Map;

/**
 * 지역목록(시, 군, 구)
 */

public class District {

    private String districtCode;

    private String regionCode;

    private String districtName;

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("District{");
        sb.append("districtCode='").append(districtCode).append('\'');
        sb.append(", regionCode='").append(regionCode).append('\'');
        sb.append(", districtName='").append(districtName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
