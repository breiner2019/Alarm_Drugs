package com.example.alarm_drugs.Clases;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(tableName = "receta_table")
public class Recetas {
    @PrimaryKey
    private int id;
    private String Fecha,Motivo,Diagnostico,estado;
    @Ignore
    private List<Drugs> Medicamentos;



    public int getId() {
        return id;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getMotivo() {
        return Motivo;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public String getEstado() {
        return estado;
    }

    public List<Drugs> getMedicamentos() {
        return Medicamentos;
    }
}

