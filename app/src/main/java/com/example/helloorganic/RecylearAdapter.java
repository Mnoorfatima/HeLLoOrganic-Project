package com.example.helloorganic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylearAdapter extends RecyclerView.Adapter<RecylearAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrcontact;
    RecylearAdapter(Context context, ArrayList<ContactModel> arrcontact){
        this.context=context;
        this.arrcontact=arrcontact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.contact ,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.imgcontact.setImageResource(arrcontact.get(position).img);
      holder.txtname.setText(arrcontact.get(position).name);
      holder.txtcontact.setText(arrcontact.get(position).number);
    }

    @Override
    public int getItemCount() {
        return arrcontact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView txtname,txtcontact;
        ImageView imgcontact;
        public ViewHolder(View itemView){
            super(itemView);
            txtname=itemView.findViewById(R.id.txtname);
            txtcontact=itemView.findViewById(R.id.txtcontact);
            imgcontact=itemView.findViewById(R.id.imgcontact);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(context,order.class);
            context.startActivities(new Intent[]{intent});
           // Intent intent1= new Intent(context,order2.class);
          //  context.startActivities(new Intent[]{intent1});
        }
    }
}