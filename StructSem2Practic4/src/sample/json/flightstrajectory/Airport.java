
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airport {

    @SerializedName("origin")
    @Expose
    public Origin origin;
    @SerializedName("destination")
    @Expose
    public Destination destination;
    @SerializedName("real")
    @Expose
    public Object real;

}
