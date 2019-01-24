package com.blogspot.yourfavoritekaisar.agendaharian.data.factory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.blogspot.yourfavoritekaisar.agendaharian.model.Barang;
import com.blogspot.yourfavoritekaisar.agendaharian.data.BarangDAO;

@Database(entities = {Barang.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BarangDAO barangDAO();

}



