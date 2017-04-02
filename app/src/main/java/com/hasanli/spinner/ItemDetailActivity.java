package com.hasanli.spinner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        TextView modeladi = (TextView) findViewById(R.id.detalModel);
        TextView modelqiymet = (TextView) findViewById(R.id.detalQiymet);
        ImageView modelsekili = (ImageView) findViewById(R.id.detalSekil);
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
            Bitmap sekil =(Bitmap) b.get("itemImage");
            if (modelsekili != null) {
                modelsekili.setImageBitmap(sekil);

            }
        }
    }
}
