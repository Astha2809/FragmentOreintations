package com.example.fragmentoreintations;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] data;
    public final Context FragmentColorsName;
    Fragment FragmentColorDescription;
    MyAdapter activity;
    int orientation;
    private final onItemClickListener listener;

    public MyAdapter(String[] data, com.example.fragmentoreintations.FragmentColorsName colorsName,
                     Context fragmentColorsName, int orientation, onItemClickListener listener) {
        this.data = data;
        this.FragmentColorsName = fragmentColorsName;
        this.orientation = orientation;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(FragmentColorsName);
        View view = layoutInflater.inflate(R.layout.colorexample, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ((TextView) holder.view.findViewById(R.id.text)).setText(data[position]);
        //holder.bind(data.get(position), listener);
        holder.bind(data[position], listener, position);

        activity = MyAdapter.this;
//        holder.fragmentlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openNewFragment();
//
//               final Bundle bundle=new Bundle();
//                bundle.putInt("keypair",position);
//                FragmentColorDescription.setArguments(bundle);
//                //int value2=activity.getResources
//                Toast.makeText(FragmentColorsName, "selected", Toast.LENGTH_SHORT).show();
//
//
//
//            }
//        });


    }

    private void openNewFragment() {
        Log.e("here", String.valueOf(orientation));
        if (orientation == 1) {
            FragmentColorDescription = new FragmentColorDescription();

            ((MainActivity) FragmentColorsName).getSupportFragmentManager().beginTransaction().
                    replace(R.id.framecontainer, FragmentColorDescription).addToBackStack("ddd").commit();
        } else {
            FragmentColorDescription = new FragmentColorDescription();

            ((MainActivity) FragmentColorsName).getSupportFragmentManager().beginTransaction().
                    replace(R.id.frame2, FragmentColorDescription).commit();
        }

        //int value=getActivity().getResources().getConfiguration().orientation;
        //if(value==)

//        Bundle bundle=new Bundle();
//        bundle.putInt("key",position);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public LinearLayout fragmentlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            fragmentlayout = (LinearLayout) itemView.findViewById(R.id.frame);


        }

        public void bind(final String data, final onItemClickListener listener, final int position) {
            itemView.setOnClickListener(new View.OnClickListener() {


                public void onClick(View v) {
                    //listener.onItemClick(data);
                    openNewFragment();
                    final Bundle bundle = new Bundle();
                    bundle.putInt(String.valueOf(R.string.keypair), position);

                    FragmentColorDescription.setArguments(bundle);

                    Toast.makeText(FragmentColorsName, "selected", Toast.LENGTH_SHORT).show();

                }
            });
        }

    }


}