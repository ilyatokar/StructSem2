
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("request")
    @Expose
    public Request request;
    @SerializedName("response")
    @Expose
    public Response response;

}
