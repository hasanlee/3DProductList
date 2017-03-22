package com.hasanli.spinner;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBcodeFragment extends Fragment {
    View view;



    public CheckBcodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bcode, container, false);

        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btnCheck = (Button) view.findViewById(R.id.btncheck);
        final EditText modelNo = (EditText) view.findViewById(R.id.modelNo);
        final TextView txtChecked = (TextView) view.findViewById(R.id.txtChecked);
        final DatabaseReference bcode = FirebaseDatabase.getInstance().getReference("spinners");

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click action
                if (modelNo.getText().toString().isEmpty()) {
                    modelNo.setError("Model nomresini daxil edin!");
                    Toast.makeText(getContext(),R.string.modeltext_empty,Toast.LENGTH_SHORT).show();
                } else {
                    bcode.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChild(modelNo.getText().toString())) {
                                //if exist
                                txtChecked.setTextColor(Color.parseColor("#FF0F9D80"));
                                txtChecked.setText(R.string.original);
                            } else {
                                //not exist
                                txtChecked.setTextColor(Color.RED);
                                txtChecked.setText(R.string.not_original);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });



    }

}
