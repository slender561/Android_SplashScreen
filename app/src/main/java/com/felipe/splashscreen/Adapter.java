package com.felipe.splashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Students> list;

    public Adapter(ArrayList<Students> lista) {
        this.list = lista;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.name.setText(list.get(position).name);
        viewHolder.image.setImageResource(list.get(position).image);
        viewHolder.RA.setText(list.get(position).RA);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detalhes_Integrantes.class);
                intent.putExtra("image", Integer.toString(list.get(position).image));
                intent.putExtra("name", list.get(position).name);
                intent.putExtra("RA", list.get(position).RA);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        TextView RA;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.image = itemView.findViewById(R.id.image);
            this.RA = itemView.findViewById(R.id.RA);
        }
    }
}
