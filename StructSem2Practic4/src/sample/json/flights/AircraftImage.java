
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AircraftImage {

    @SerializedName("registration")
    @Expose
    public String registration;
    @SerializedName("images")
    @Expose
    public Images images;

}
