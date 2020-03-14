
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status_ {

    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("diverted")
    @Expose
    public Object diverted;

}
