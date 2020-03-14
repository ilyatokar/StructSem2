
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification_ {

    @SerializedName("modes")
    @Expose
    public String modes;
    @SerializedName("registration")
    @Expose
    public String registration;
    @SerializedName("serialNo")
    @Expose
    public Object serialNo;
    @SerializedName("age")
    @Expose
    public Age age;

}
