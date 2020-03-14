
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aircraft {

    @SerializedName("model")
    @Expose
    public Model model;
    @SerializedName("identification")
    @Expose
    public Identification_ identification;
    @SerializedName("availability")
    @Expose
    public Availability availability;

}
