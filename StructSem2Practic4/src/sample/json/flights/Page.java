
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("current")
    @Expose
    public Integer current;
    @SerializedName("more")
    @Expose
    public Boolean more;
    @SerializedName("total")
    @Expose
    public Object total;

}
