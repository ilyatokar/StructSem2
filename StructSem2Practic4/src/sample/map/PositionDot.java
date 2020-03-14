package sample.map;

public class PositionDot {
    public String UTC;
    public String latitude;
    public String longitude;


    public String getUTC() {
        return UTC;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public PositionDot(String UTC, String latitude, String longitude) {
        this.UTC = UTC;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
