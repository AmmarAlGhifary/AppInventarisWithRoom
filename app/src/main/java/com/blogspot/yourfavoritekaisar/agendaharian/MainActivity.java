package com.blogspot.yourfavoritekaisar.agendaharian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCreate = findViewById(R.id.bt_createdata);
        Button btView = findViewById(R.id.bt_viewdata);

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RoomCreateActivity.getActIntent(MainActivity.this));
            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RoomReadActivity.getActIntent(MainActivity.this));
            }
        });
    }
}
