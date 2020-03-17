package com.example.fragmentoreintations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentColorDescription extends Fragment {
View rootview;
 TextView colordescriptiontextView;
Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragmentcolordescription,container,false);//to create standalone
        // layout we cn make attchtoroot true
        initUi();
        Bundle bundle=getArguments();
        int args=0;
        if(bundle!=null){
             args=bundle.getInt("keypair");
        }

        switch (args){
            case 0 :
                colordescriptiontextView.setText("color1");
                break;
            case 1:
                colordescriptiontextView.setText("color2");
                break;

            case 2:
                colordescriptiontextView.setText("color3");
                break;
            case 3:
                colordescriptiontextView.setText("color4");
            case 5:
                colordescriptiontextView.setText("color5");

        }
        return rootview;

    }
   private void initUi(){
        context=getContext();
        colordescriptiontextView=rootview.findViewById(R.id.colordescription);
   }


}


