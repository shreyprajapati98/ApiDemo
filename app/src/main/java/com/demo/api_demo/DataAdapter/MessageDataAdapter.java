package com.demo.api_demo.DataAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.api_demo.Model.MessageResponse;
import com.demo.api_demo.R;

import java.util.List;
public class MessageDataAdapter extends RecyclerView.Adapter<
        MessageDataAdapter.MyViewHolder> {
    private List<MessageResponse> messageDataList;
    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,title,body;
        MyViewHolder(View view){
            super(view);
            id = (TextView) view.findViewById(R.id.tv_id);
            title = (TextView) view.findViewById(R.id.tv_message_title);
            body = (TextView) view.findViewById(R.id.tv_message); }
    }
    public MessageDataAdapter(List<MessageResponse> messageDataList) {
        this.messageDataList = messageDataList; }
    @NonNull
    @Override
    public MessageDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_apidata,parent,false);
        return new MessageDataAdapter.MyViewHolder(itemView); }
    @Override
    public void onBindViewHolder(MessageDataAdapter.MyViewHolder holder, int position) {
        MessageResponse data = messageDataList.get(position);
        holder.id.setText(data.getId().toString());
        holder.title.setText(data.getTitle());
        holder.body.setText(data.getBody());
    }
    @Override
    public int getItemCount() {
        return messageDataList.size();
    }}
