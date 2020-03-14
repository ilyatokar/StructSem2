
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Number {

    @SerializedName("default")
    @Expose
    public String _default;
    @SerializedName("alternative")
    @Expose
    public Object alternative;

}
