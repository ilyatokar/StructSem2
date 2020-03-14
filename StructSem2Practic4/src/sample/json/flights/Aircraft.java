
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aircraft {

    @SerializedName("model")
    @Expose
    public Model model;
    @SerializedName("hex")
    @Expose
    public String hex;
    @SerializedName("registration")
    @Expose
    public String registration;
    @SerializedName("serialNo")
    @Expose
    public Object serialNo;
    @SerializedName("age")
    @Expose
    public Age age;
    @SerializedName("restricted")
    @Expose
    public Boolean restricted;
    @SerializedName("availability")
    @Expose
    public Availability availability;
    @SerializedName("country")
    @Expose
    public Country country;

}
