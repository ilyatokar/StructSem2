package sample.json.flightstrajectory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("offset")
    @Expose
    public Integer offset;
    @SerializedName("abbr")
    @Expose
    public String abbr;
    @SerializedName("abbrName")
    @Expose
    public String abbrName;
    @SerializedName("isDst")
    @Expose
    public Boolean isDst;

}
