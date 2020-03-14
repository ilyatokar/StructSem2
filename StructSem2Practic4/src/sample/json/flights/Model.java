
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("text")
    @Expose
    public String text;

}
