
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Origin {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("code")
    @Expose
    public Code__ code;
    @SerializedName("position")
    @Expose
    public Position position;
    @SerializedName("timezone")
    @Expose
    public Timezone timezone;

}
