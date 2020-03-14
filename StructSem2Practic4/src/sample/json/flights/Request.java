
package sample.json.flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("callback")
    @Expose
    public Object callback;
    @SerializedName("device")
    @Expose
    public Object device;
    @SerializedName("fetchBy")
    @Expose
    public String fetchBy;
    @SerializedName("filterBy")
    @Expose
    public Object filterBy;
    @SerializedName("format")
    @Expose
    public String format;
    @SerializedName("limit")
    @Expose
    public Integer limit;
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("pk")
    @Expose
    public Object pk;
    @SerializedName("query")
    @Expose
    public String query;
    @SerializedName("timestamp")
    @Expose
    public Object timestamp;
    @SerializedName("token")
    @Expose
    public Object token;

}
