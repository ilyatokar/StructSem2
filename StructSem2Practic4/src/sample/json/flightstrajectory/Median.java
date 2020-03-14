
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Median {

    @SerializedName("time")
    @Expose
    public Integer time;
    @SerializedName("delay")
    @Expose
    public Integer delay;
    @SerializedName("timestamp")
    @Expose
    public Integer timestamp;

}
