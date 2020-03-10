package sample;

import java.util.Date;

public class RecordItem {
    String DateRecord;
    String Id;
    int Nominal;
    Double Value;

    public RecordItem(String dateRecord, String id, int nominal, Double value) {
        DateRecord = dateRecord;
        Id = id;
        Nominal = nominal;
        Value = value;
    }

    @Override
    public String toString() {
        return "Record{" +
                "DateRecord=" + DateRecord +
                ", Id='" + Id + '\'' +
                ", Nominal=" + Nominal +
                ", Value=" + Value +
                '}';
    }
}
