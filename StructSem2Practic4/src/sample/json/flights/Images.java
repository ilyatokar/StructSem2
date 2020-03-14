
package sample.json.flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("thumbnails")
    @Expose
    public List<Thumbnail> thumbnails = null;
    @SerializedName("medium")
    @Expose
    public List<Medium> medium = null;
    @SerializedName("large")
    @Expose
    public List<Large> large = null;

}
