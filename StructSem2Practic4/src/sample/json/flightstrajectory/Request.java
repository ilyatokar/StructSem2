
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("callback")
    @Expose
    public Object callback;
    @SerializedName("device")
    @Expose
    public Object device;
    @SerializedName("flightId")
    @Expose
    public String flightId;
    @SerializedName("format")
    @Expose
    public String format;
    @SerializedName("pk")
    @Expose
    public Object pk;
    @SerializedName("timestamp")
    @Expose
    public Integer timestamp;
    @SerializedName("token")
    @Expose
    public Object token;

}
