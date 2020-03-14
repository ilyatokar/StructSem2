
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Real {

    @SerializedName("departure")
    @Expose
    public Integer departure;
    @SerializedName("arrival")
    @Expose
    public Object arrival;

}
