package com.demo.api_demo.DataAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.api_demo.Model.MResponse;
import com.demo.api_demo.R;

import java.util.List;

public class MDataAdapter extends RecyclerView.Adapter<MDataAdapter.MyViewHolder> {

    private List<MResponse> commentList;

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,name,body;

        MyViewHolder(View view){
            super(view);
            id = (TextView) view.findViewById(R.id.tv_id);
            name = (TextView) view.findViewById(R.id.tv_message_title);
            body = (TextView) view.findViewById(R.id.tv_message);
        }
    }

    public MDataAdapter(List<MResponse> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public MDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_apidata,parent,false);

        return new MDataAdapter.MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull MDataAdapter.MyViewHolder holder, int position) {
        MResponse data = commentList.get(position);
        holder.id.setText(data.getId().toString());
        holder.name.setText(data.getName());
        holder.body.setText(data.getBody());


    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
