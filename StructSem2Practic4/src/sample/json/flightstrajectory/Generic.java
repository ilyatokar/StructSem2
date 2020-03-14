
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Generic {

    @SerializedName("status")
    @Expose
    public Status_ status;
    @SerializedName("eventTime")
    @Expose
    public EventTime eventTime;

}
