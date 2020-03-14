
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("legalNotice")
    @Expose
    public String legalNotice;

}
