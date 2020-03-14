
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("live")
    @Expose
    public Boolean live;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("estimated")
    @Expose
    public Object estimated;
    @SerializedName("ambiguous")
    @Expose
    public Boolean ambiguous;
    @SerializedName("generic")
    @Expose
    public Generic generic;

}
