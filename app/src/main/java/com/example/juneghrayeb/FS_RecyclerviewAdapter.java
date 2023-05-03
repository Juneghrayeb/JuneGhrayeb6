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
 class FS_RecyclerviewAdapter extends RecyclerView.Adapter<FS_RecyclerviewAdapter.MyViewHolder> {
     private final RecyclerViewInterface2 recyclerViewInterface2;

             Context context;
             ArrayList<Footballshirtsmodel> footballshirtsmodels;



    public FS_RecyclerviewAdapter(Context context, ArrayList<Footballshirtsmodel> footballshirtsmodels ,
                                  RecyclerViewInterface2 recyclerViewInterface2){
        this.context= context;
        this.footballshirtsmodels = footballshirtsmodels;
        this.recyclerViewInterface2 = recyclerViewInterface2;

    }
    @NonNull
    @Override
    public FS_RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is where you inflate the layout (giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerviewrowforfooyballshirts,parent,false);

        return new FS_RecyclerviewAdapter.MyViewHolder(view , recyclerViewInterface2);
    }

    @Override
    public void onBindViewHolder(@NonNull FS_RecyclerviewAdapter.MyViewHolder holder, int position) {
// assigning values to the view we created in the recycler_view_row layout file
        //based on the position of the recycler view
        holder.tvNameFS.setText(footballshirtsmodels.get(position).getFootballshirtsname());
        holder.imageView.setImageResource(footballshirtsmodels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items  that you want displayed

        return footballshirtsmodels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the view from our recycler_view_row layout file
        //kinda like in the oncreate method

        ImageView imageView;
        TextView tvNameFS;
        public MyViewHolder(@NonNull View itemView , RecyclerViewInterface2 recyclerViewInterface2) {
            super(itemView);

            imageView = itemView.findViewById(R.id.barcakit);
            tvNameFS = itemView.findViewById(R.id.footballteamname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ( recyclerViewInterface2 != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface2.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
