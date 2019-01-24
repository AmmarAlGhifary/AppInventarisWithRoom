package com.blogspot.yourfavoritekaisar.agendaharian;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.yourfavoritekaisar.agendaharian.data.factory.AppDatabase;
import com.blogspot.yourfavoritekaisar.agendaharian.model.Barang;

public class RoomCreateActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_create);

        // Initiate pemanggilan room database

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "barangDB").build();

        final EditText etNamaBarang = findViewById(R.id.et_namabarang);
        final EditText etMerkBarang = findViewById(R.id.et_merkbarang);
        final EditText etHargaBarang = findViewById(R.id.et_hargabarang);
        Button btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Barang b = new Barang();
                b.setHargaBarang(etHargaBarang.getText().toString());
                b.setMerkBarang(etMerkBarang.getText().toString());
                b.setNamaBarang(etNamaBarang.getText().toString());
                insertData(b);
            }
        });


    }

    private  void insertData(final Barang b) {
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                // melakukan proses insert data
                long status = database.barangDAO().insertBarang(b);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }


public static Intent getActIntent(Activity activity) {
    return new Intent(activity, RoomCreateActivity.class);


    }

}
