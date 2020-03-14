
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {

    @SerializedName("scheduled")
    @Expose
    public Scheduled scheduled;
    @SerializedName("real")
    @Expose
    public Real real;
    @SerializedName("estimated")
    @Expose
    public Estimated estimated;
    @SerializedName("other")
    @Expose
    public Other other;

}
