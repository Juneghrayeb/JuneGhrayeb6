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

public class SE_RecyclerviewAdapter extends RecyclerView.Adapter <SE_RecyclerviewAdapter.MyViewHolder>{
    private final RecylcerViewInterface3 recylcerViewInterface3;

    Context context ;
    ArrayList<SpecialEdditionModel> specialEdditionModels ;


    public  SE_RecyclerviewAdapter(Context context, ArrayList<SpecialEdditionModel> specialEdditionModels,
                                   RecylcerViewInterface3 recylcerViewInterface3){
        this.context=context;
        this.specialEdditionModels=specialEdditionModels;
        this.recylcerViewInterface3=recylcerViewInterface3;
    }
    @NonNull
    @Override
    public SE_RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_rowsp,parent, false);

        return new SE_RecyclerviewAdapter.MyViewHolder(view,recylcerViewInterface3);
    }

    @Override
    public void onBindViewHolder(@NonNull SE_RecyclerviewAdapter.MyViewHolder holder, int position) {

        holder.tvname.setText(specialEdditionModels.get(position).getSpecialEdditionName());
        holder.imageView.setImageResource(specialEdditionModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return specialEdditionModels.size();
    }
    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvname;

        public MyViewHolder(@NonNull View itemView,RecylcerViewInterface3 recylcerViewInterface3) {
            super(itemView);

            imageView = itemView.findViewById(R.id.Mardonajpg);
            tvname = itemView.findViewById(R.id.Mardona2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recylcerViewInterface3 != null){
                        int pos = getAdapterPosition();
                        if (pos !=RecyclerView.NO_POSITION){
                            recylcerViewInterface3.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
