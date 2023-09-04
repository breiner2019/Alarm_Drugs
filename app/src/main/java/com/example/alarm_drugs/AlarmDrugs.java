package com.example.alarm_drugs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.example.alarm_drugs.Clases.Acudiente;
import com.example.alarm_drugs.Clases.Drugs;
import com.example.alarm_drugs.Clases.HistoriaClinica;
import com.google.gson.Gson;

@Entity(tableName = "Alarm_Drugs_Table")
public class AlarmDrugs {

    //Creation vars
    @PrimaryKey 
    private int AlarmDrugsId;



    public void setAlarmDrugsId(int alarmDrugsId) {
        AlarmDrugsId = alarmDrugsId;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public void setId_drugs(int id_drugs) {
        Id_drugs = id_drugs;
    }

    public void setStarted(boolean started) {
        Started = started;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    private int Minute, Hour;

    private int Id_drugs;
    private int Id_user;
    private boolean Started;
    long created;

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int id_user) {
        Id_user = id_user;
    }

    public int getAlarmDrugsId() {
        return AlarmDrugsId;
    }

    public int getMinute() {
        return Minute;
    }

    public int getHour() {
        return Hour;
    }

    public int getId_drugs() {
        return Id_drugs;
    }

    public boolean isStarted() {
        return Started;
    }

    public long getCreated() {
        return created;
    }

    public static class Converters {


        @TypeConverter
        public Acudiente fromStringAcudiente (String value) {
            return new Gson().fromJson(value, Acudiente.class);
        }

        @TypeConverter
        public String fromAcudiente (Acudiente Acudiente) {
            return new Gson().toJson(Acudiente);
        }

        @TypeConverter
        public HistoriaClinica fromStringHistoria (String value) {
            return new Gson().fromJson(value, HistoriaClinica.class);
        }

        @TypeConverter
        public String fromHistoria (HistoriaClinica HistoriaClinica) {
            return new Gson().toJson(HistoriaClinica);
        }
    }


}
