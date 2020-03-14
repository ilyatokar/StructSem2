
package sample.json.flightstrajectory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Destination {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("code")
    @Expose
    public Code___ code;
    @SerializedName("position")
    @Expose
    public Position_ position;
    @SerializedName("timezone")
    @Expose
    public Timezone_ timezone;

}
