
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Availability {

    @SerializedName("serialNo")
    @Expose
    public Boolean serialNo;
    @SerializedName("age")
    @Expose
    public Boolean age;

}
