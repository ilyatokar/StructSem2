
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("current")
    @Expose
    public Integer current;
    @SerializedName("total")
    @Expose
    public Object total;
    @SerializedName("limit")
    @Expose
    public Integer limit;

}
