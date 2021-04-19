package com.example.androidtourismapplication;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    List<OurData> mData;

    public RecyclerViewAdapter(Context mContext, List<OurData> mData){
        this.mContext = mContext;
        this.mData = mData;
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private ImageView img;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_name =(TextView) itemView.findViewById(R.id.itemText);
            img = (ImageView) itemView.findViewById(R.id.itemImage);
        }
    }

}



