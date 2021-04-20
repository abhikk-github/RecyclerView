package com.abhikk.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class nextActivity extends AppCompatActivity {

    TextView one_id_next, two_id_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        one_id_next = findViewById(R.id.one_id_next);
        two_id_next = findViewById(R.id.two_id_next);

        getDataAndSetData();
    }

    private void getDataAndSetData() {
        if (getIntent().hasExtra("data1")&&getIntent().hasExtra("data2")){

            one_id_next.setText(getIntent().getStringExtra("data1"));
            two_id_next.setText(getIntent().getStringExtra("data2"));

        }else{
            Toast.makeText(this, "No Data",Toast.LENGTH_LONG).show();
        }
    }

}