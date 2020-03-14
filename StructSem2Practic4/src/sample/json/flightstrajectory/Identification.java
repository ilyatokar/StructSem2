
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("number")
    @Expose
    public Number number;
    @SerializedName("callsign")
    @Expose
    public String callsign;

}
