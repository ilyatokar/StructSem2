
package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail {

    @SerializedName("src")
    @Expose
    public String src;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("source")
    @Expose
    public String source;

}
