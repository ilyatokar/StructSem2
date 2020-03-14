
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Speed {

    @SerializedName("kmh")
    @Expose
    public Float kmh;
    @SerializedName("kts")
    @Expose
    public Integer kts;
    @SerializedName("mph")
    @Expose
    public Float mph;

}
