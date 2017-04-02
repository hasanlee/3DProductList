package com.hasanli.spinner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    View view;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView= (ListView) view.findViewById(R.id.liste);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("spinners");
        FirebaseListAdapter mAdapter = new FirebaseListAdapter<SpinnerModel>(getActivity(), SpinnerModel.class, R.layout.iste, ref) {
            @Override
            protected void populateView(View view, SpinnerModel spindata, int position) {
                ((TextView)view.findViewById(R.id.txtModeli2)).setText(spindata.getName());
                ((TextView)view.findViewById(R.id.txtQiymeti2)).setText(spindata.getPrice().toString()+" AZN");
                ImageView mImageView = (ImageView) view.findViewById(R.id.imgSekil2);
                Picasso.with(getContext()).load(spindata.getImage()).into(mImageView);
                Boolean vipstatus = false;

                if(vipstatus == true){
                    Button btn = (Button) view.findViewById(R.id.txtQiymeti2);
                    btn.setBackgroundColor(Color.RED);
                }



            }
        };

        listView.setAdapter(mAdapter);
    }


    @Override
    public void onStart(){
        super.onStart();
        //onitemclicklistener yeri
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SpinnerModel itemNo = (SpinnerModel) listView.getItemAtPosition(position);
                TextView txtModel = (TextView) view.findViewById(R.id.txtModeli2);
                TextView txtQiymet = (TextView) view.findViewById(R.id.txtQiymeti2);
                ImageView imgSekil = (ImageView) view.findViewById(R.id.imgSekil2);
                String itemName = txtModel.getText().toString();
                String itemPrice = txtQiymet.getText().toString();
                imgSekil.buildDrawingCache();
                Bitmap itemImage = imgSekil.getDrawingCache();


                Toast.makeText(getContext(),"You selected :" + itemName + " " + itemPrice,Toast.LENGTH_SHORT).show();

                Intent itemdetal = new Intent(getContext(),ItemDetailActivity.class);
                itemdetal.putExtra("itemImage",itemImage);
                itemdetal.putExtra("txtModel",itemName);
                itemdetal.putExtra("txtQiymet",itemPrice);
                startActivity(itemdetal);

            }
        });
        //test changes

    }


}
