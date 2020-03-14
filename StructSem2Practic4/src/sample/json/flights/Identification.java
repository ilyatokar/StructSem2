
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("row")
    @Expose
    public Double row;
    @SerializedName("number")
    @Expose
    public Number number;
    @SerializedName("callsign")
    @Expose
    public String callsign;
    @SerializedName("codeshare")
    @Expose
    public Object codeshare;

}
