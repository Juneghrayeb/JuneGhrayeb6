package com.example.juneghrayeb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class NK_RecyclerviewAdapter extends RecyclerView.Adapter<NK_RecyclerviewAdapter.MyViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;


    Context context;
    ArrayList<Nationalmodel> nationalmodels;

    public NK_RecyclerviewAdapter(Context context, ArrayList<Nationalmodel> nationalmodels,
                                  RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.nationalmodels= nationalmodels;
        this.recyclerViewInterface= recyclerViewInterface;
    }
    @NonNull
    @Override
    public NK_RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is where you inflate the layout (giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);
        return  new NK_RecyclerviewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NK_RecyclerviewAdapter.MyViewHolder holder, int position) {
// assigning values to the view we created in the recycler_view_row layout file
        //based on the position of the recycler view

        holder.tvName.setText(nationalmodels.get(position).getNationalkitsname());
        holder.imageView.setImageResource(nationalmodels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items  that you want displayed
        return nationalmodels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //grabbing the view from our recycler_view_row layout file
        //kinda like in the oncreate method

        ImageView imageView;
        TextView tvName;

        public MyViewHolder(@NonNull View itemView , RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.brazilimage);
            tvName = itemView.findViewById(R.id.Brazilkit);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){

                        int pos = getAdapterPosition();
                        if (pos !=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
