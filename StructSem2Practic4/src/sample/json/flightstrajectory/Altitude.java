
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Altitude {

    @SerializedName("feet")
    @Expose
    public Integer feet;
    @SerializedName("meters")
    @Expose
    public Integer meters;

}
