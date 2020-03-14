
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Other {

    @SerializedName("eta")
    @Expose
    public Integer eta;
    @SerializedName("updated")
    @Expose
    public Integer updated;
    @SerializedName("duration")
    @Expose
    public Integer duration;

}
