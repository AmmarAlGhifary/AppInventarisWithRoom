package com.blogspot.yourfavoritekaisar.agendaharian.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.blogspot.yourfavoritekaisar.agendaharian.model.Barang;

@Dao
public interface BarangDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertBarang(Barang barang);

    @Update
    int updateBarang(Barang barang);

    @Delete
    int deleteBarang(Barang barang);

    @Query("SELECT * FROM tbBarang")
    Barang[] selectAllBarangs();

    @Query("SELECT * FROM tbBarang WHERE barangId = :id LIMIT 1")
    Barang selectBarangDetail(int id);
    }

