package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.json.flightstrajectory.Flight;


public class FlyModel {
    private SimpleStringProperty DateFlight;
    private SimpleStringProperty Status;
    private SimpleStringProperty TownFrom;
    private Double positionFromX;
    private Double positionFromY;
    private SimpleStringProperty TownTo;
    private Double positionToX;
    private Double positionToY;
    private String FlightId;
    private Integer UTC;


    public FlyModel(SimpleStringProperty dateFlight,
                    SimpleStringProperty status,
                    SimpleStringProperty townFrom,
                    Double positionFromX,
                    Double positionFromY,
                    SimpleStringProperty townTo,
                    Double positionToX,
                    Double positionToY,
                    String flightId,
                    Integer UTC) {
        this.DateFlight = dateFlight;
        this.Status = status;
        this.TownFrom = townFrom;
        this.positionFromX = positionFromX;
        this.positionFromY = positionFromY;
        this.TownTo = townTo;
        this.positionToX = positionToX;
        this.positionToY = positionToY;
        this.FlightId = flightId;
        this.UTC = UTC;
    }



    @Override
    public String toString() {
        return "FlyModel{" +
                "DateFlight=" + DateFlight +
                ", Status=" + Status +
                ", TownFrom=" + TownFrom +
                ", positionFromX=" + positionFromX +
                ", positionFromY=" + positionFromY +
                ", TownTo=" + TownTo +
                ", positionToX=" + positionToX +
                ", positionToY=" + positionToY +
                ", FlightId='" + FlightId + '\'' +
                ", UTC=" + UTC +
                '}';
    }

    public String getDateFlight() {
        return DateFlight.get();
    }

    public SimpleStringProperty dateFlightProperty() {
        return DateFlight;
    }

    public void setDateFlight(String dateFlight) {
        this.DateFlight.set(dateFlight);
    }

    public Integer getUTC() {
        return UTC;
    }

    public void setUTC(Integer UTC) {
        this.UTC = UTC;
    }

    public String getStatus() {
        return Status.get();
    }

    public SimpleStringProperty statusProperty() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }

    public String getTownFrom() {
        return TownFrom.get();
    }

    public SimpleStringProperty townFromProperty() {
        return TownFrom;
    }

    public void setTownFrom(String townFrom) {
        this.TownFrom.set(townFrom);
    }

    public Double getPositionFromX() {
        return positionFromX;
    }

    public void setPositionFromX(Double positionFromX) {
        this.positionFromX = positionFromX;
    }

    public Double getPositionFromY() {
        return positionFromY;
    }

    public void setPositionFromY(Double positionFromY) {
        this.positionFromY = positionFromY;
    }

    public String getTownTo() {
        return TownTo.get();
    }

    public SimpleStringProperty townToProperty() {
        return TownTo;
    }

    public void setTownTo(String townTo) {
        this.TownTo.set(townTo);
    }

    public Double getPositionToX() {
        return positionToX;
    }

    public void setPositionToX(Double positionToX) {
        this.positionToX = positionToX;
    }

    public Double getPositionToY() {
        return positionToY;
    }

    public void setPositionToY(Double positionToY) {
        this.positionToY = positionToY;
    }

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
    }
}
