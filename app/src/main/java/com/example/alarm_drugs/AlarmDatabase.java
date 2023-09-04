package com.example.alarm_drugs;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.alarm_drugs.Clases.Drugs;
import com.example.alarm_drugs.Clases.User;

import java.net.UnknownServiceException;

@Database(entities = {AlarmDrugs.class, User.class, Drugs.class}, version = 1)
@TypeConverters({User.Converters.class})
public abstract class AlarmDatabase extends RoomDatabase {

    private static AlarmDatabase instance;
    public abstract AlarmDrugsDao AlarmDrugsDao();

    public static synchronized AlarmDatabase getInstance(Context context){
        if (instance == null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    AlarmDatabase.class, "Alarms_DataBase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }
}
