
package sample.json.flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("item")
    @Expose
    public Item item;
    @SerializedName("page")
    @Expose
    public Page page;
    @SerializedName("timestamp")
    @Expose
    public Integer timestamp;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;
    @SerializedName("aircraftInfo")
    @Expose
    public Object aircraftInfo;
    @SerializedName("aircraftImages")
    @Expose
    public List<AircraftImage> aircraftImages = null;

}
