package ksmart.ks48team01.user.dto;

public class Area {

    private String regionCode;
    private String regionName;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Area{");
        sb.append("regionCode=").append(regionCode);
        sb.append(", regionName='").append(regionName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
