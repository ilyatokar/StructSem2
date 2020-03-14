
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("alpha2")
    @Expose
    public String alpha2;
    @SerializedName("alpha3")
    @Expose
    public String alpha3;

}
