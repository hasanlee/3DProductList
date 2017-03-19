package com.hasanli.spinner;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    View view;
    TextView promoView;
    Button btnLoad;


    String[] MODEL ={"Red Standard","Black Standard","White Standard","Red Small"};
    String[] QIYMET ={"5.0","4.50","2.35","5.45"};
    int[] SEKIL ={R.mipmap.spinner,R.mipmap.spinner,R.mipmap.spinner,R.mipmap.spinner};

    FirebaseRemoteConfig mFirebaseRemoteConfig;
    private static final String PROMO_MESSAGE = "promo_message";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        //Firebase Remote Config ayarlari
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        promoView = (TextView) view.findViewById(R.id.promotext);
        btnLoad = (Button) view.findViewById(R.id.button);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                melumatCek();
            }
        });


        ListView listView= (ListView) view.findViewById(R.id.liste);
        CustomAdapter customAdapter = new CustomAdapter(getActivity());
        listView.setAdapter(customAdapter);
    }



    private void melumatCek() {
        promoView.setText(mFirebaseRemoteConfig.getString(PROMO_MESSAGE));
    }



    class CustomAdapter extends ArrayAdapter {

        @Override
        public long getItemId(int position) {
            return 0;
        }

        CustomAdapter(Context context){
            super(context,R.layout.iste);
        }

        @Override
        public View getView(int position, View view2, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());

            view2 = inflater.inflate(R.layout.iste,null);

            ImageView sekil = (ImageView) view2.findViewById(R.id.imgSekil2);
            TextView txtModel = (TextView) view2.findViewById(R.id.txtModeli2);
            TextView txtQiymet = (TextView) view2.findViewById(R.id.txtQiymeti2);

            sekil.setImageResource(SEKIL[position]);
            txtModel.setText(MODEL[position]);
            txtQiymet.setText(QIYMET[position]);

            return view2;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return MODEL.length;
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        //onitemclicklistener yeri
        //test changes

    }


}
