
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventTime {

    @SerializedName("utc")
    @Expose
    public Integer utc;
    @SerializedName("local")
    @Expose
    public Integer local;

}
