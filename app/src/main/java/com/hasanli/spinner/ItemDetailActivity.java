package com.hasanli.spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        TextView modeladi = (TextView) findViewById(R.id.detalModel);
        TextView modelqiymet = (TextView) findViewById(R.id.detalQiymet);
        Intent itemdetal= getIntent();
        Bundle b = itemdetal.getExtras();
        if(b!=null)
        {
            String adi =(String) b.get("txtModel");
            if (modeladi != null) {
                modeladi.setText(adi);
            }
            String qiymet =(String) b.get("txtQiymet");
            if (modelqiymet != null) {
                modelqiymet.setText(qiymet);
            }
        }
    }
}
