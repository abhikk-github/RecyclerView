package com.abhikk.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    String data1[], data2[];

     public RecyclerViewAdapter(Context ct,String s1[], String s2[]){
         context = ct;
         data1 = s1;
         data2 = s2;
     }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

         holder.text_one.setText(data1[position]);
         holder.text_two.setText(data2[position]);
         holder.row_id.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, nextActivity.class);
                 intent.putExtra("data1",data1[position]);
                 intent.putExtra("data2",data2[position]);
                 context.startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

         TextView  text_one , text_two;
         LinearLayout row_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text_one = itemView.findViewById(R.id.one_id);
            text_two = itemView.findViewById(R.id.two_id);
            row_id = itemView.findViewById(R.id.row_id);

        }
    }
}
