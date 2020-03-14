
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("flight")
    @Expose
    public Flight flight;

}
