package com.example.alarm_drugs.Clases;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drugs_table")
public class Drugs {
    @PrimaryKey
    private int Id;
    private String Nombre;
    private String Tipo;
    private String Cantidad;
    private int Tiempo;
    private int Total;
    private String info;
    private String Codigo;
    private String Contraindicacciones;

    private int id_receta;








    public String getContraindicacciones() {
        return Contraindicacciones;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getInfo() {
        return info;
    }

    public int getTotal() {
        return Total;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getId() {
        return Id;
    }


}
