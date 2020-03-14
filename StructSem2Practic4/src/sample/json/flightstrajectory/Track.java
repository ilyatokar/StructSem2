
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
    @SerializedName("altitude")
    @Expose
    public Altitude altitude;
    @SerializedName("speed")
    @Expose
    public Speed speed;
    @SerializedName("verticalSpeed")
    @Expose
    public VerticalSpeed verticalSpeed;
    @SerializedName("heading")
    @Expose
    public Integer heading;
    @SerializedName("squawk")
    @Expose
    public String squawk;
    @SerializedName("timestamp")
    @Expose
    public Integer timestamp;
    @SerializedName("ems")
    @Expose
    public Object ems;

}
