
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flights {

    @SerializedName("result")
    @Expose
    public Result result;
    @SerializedName("_api")
    @Expose
    public Api api;

}
