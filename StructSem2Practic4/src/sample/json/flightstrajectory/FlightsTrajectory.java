
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightsTrajectory {

    @SerializedName("result")
    @Expose
    public Result result;
    @SerializedName("_api")
    @Expose
    public Api api;

}
