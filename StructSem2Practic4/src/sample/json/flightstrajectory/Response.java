package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("timestamp")
    @Expose
    public Integer timestamp;
    @SerializedName("data")
    @Expose
    public Data data;

}
