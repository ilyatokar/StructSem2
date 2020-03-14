
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scheduled {

    @SerializedName("departure")
    @Expose
    public Object departure;
    @SerializedName("arrival")
    @Expose
    public Object arrival;

}
