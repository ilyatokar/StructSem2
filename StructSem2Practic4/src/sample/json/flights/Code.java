
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Code {

    @SerializedName("iata")
    @Expose
    public String iata;
    @SerializedName("icao")
    @Expose
    public String icao;

}
