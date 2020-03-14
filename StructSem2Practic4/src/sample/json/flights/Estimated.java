
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estimated {

    @SerializedName("departure")
    @Expose
    public Object departure;
    @SerializedName("arrival")
    @Expose
    public Integer arrival;

}
