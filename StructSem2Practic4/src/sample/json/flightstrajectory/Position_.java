
package sample.json.flightstrajectory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position_ {

    @SerializedName("latitude")
    @Expose
    public Float latitude;
    @SerializedName("longitude")
    @Expose
    public Float longitude;
    @SerializedName("country")
    @Expose
    public Country_ country;
    @SerializedName("region")
    @Expose
    public Region_ region;

}
