package sample.json.flightstrajectory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerticalSpeed {

    @SerializedName("fpm")
    @Expose
    public Integer fpm;
    @SerializedName("ms")
    @Expose
    public Double ms;

}
