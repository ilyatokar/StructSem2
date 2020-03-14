
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("code")
    @Expose
    public Code code;

}
