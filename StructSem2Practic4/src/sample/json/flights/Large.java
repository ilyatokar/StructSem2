
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Large {

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
