package com.example.fragmentoreintations;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

;import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentColorsName extends Fragment {
    private int orientation;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] ar = new String[10];
    Context context;
    View rootView;
    private onItemClickListener listener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orientation = getArguments().getInt("oritentation");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragmentcolornames, container, false);
        initUi();



        return rootView;
    }

    private void initUi() {
        context = getContext();


        // adapter=new com.example.fragmentsession.MyAdapter(ar,this.getBaseContext());
        // adapter=new com.example.fragmentsession.MyAdapter(this,ar);
        // recyclerView.setAdapter(adapter);

        ar[0] = "red";
        ar[1] = "orange";
        ar[2] = "yellow";
        ar[3] = "blue";
        ar[4] = "green";
        ar[5] = "grey";
        ar[6] = "white";
        ar[7] = "peach";
        ar[8] = "brown";
        ar[9] = "purple";
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_main2);
        // recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        //adapter = new MyAdapter(ar, this, context, orientation);
        adapter = new MyAdapter(ar, this, context, orientation, listener);
        recyclerView.setAdapter(adapter);


    }


}


