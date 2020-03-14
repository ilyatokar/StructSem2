
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("identification")
    @Expose
    public Identification identification;
    @SerializedName("status")
    @Expose
    public Status status;
    @SerializedName("aircraft")
    @Expose
    public Aircraft aircraft;
    @SerializedName("owner")
    @Expose
    public Owner owner;
    @SerializedName("airline")
    @Expose
    public Airline airline;
    @SerializedName("airport")
    @Expose
    public Airport airport;
    @SerializedName("time")
    @Expose
    public Time time;

}
