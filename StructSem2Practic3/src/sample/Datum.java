package sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("temperature")
    @Expose
    public Float temperature;
    @SerializedName("temperature_min")
    @Expose
    public Float temperatureMin;
    @SerializedName("temperature_max")
    @Expose
    public Float temperatureMax;
    @SerializedName("precipitation")
    @Expose
    public Object precipitation;
    @SerializedName("snowfall")
    @Expose
    public Object snowfall;
    @SerializedName("snowdepth")
    @Expose
    public Integer snowdepth;
    @SerializedName("winddirection")
    @Expose
    public Object winddirection;
    @SerializedName("windspeed")
    @Expose
    public Object windspeed;
    @SerializedName("peakgust")
    @Expose
    public Object peakgust;
    @SerializedName("sunshine")
    @Expose
    public Object sunshine;
    @SerializedName("pressure")
    @Expose
    public Object pressure;

}