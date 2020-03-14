
package sample.json.flightstrajectory;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flight {

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
    @SerializedName("median")
    @Expose
    public Median median;
    @SerializedName("track")
    @Expose
    public List<Track> track = null;
    @SerializedName("aircraftImages")
    @Expose
    public AircraftImages aircraftImages;
    @SerializedName("availability")
    @Expose
    public Availability_ availability;

}
