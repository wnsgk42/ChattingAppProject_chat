package com.example.practicechattingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HChattingListAdapter extends RecyclerView.Adapter<HChattingListAdapter.MyViewHolder> {
    private List<HChattingListData> hCLADataset; //HChattingListData의 값을 받기 위한 변수
    private ArrayList<HChattingListData> myDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView hChattingListRoomName; //채팅방 이름
        public TextView hChattingListChat;//채팅방 마지막 채팅
        public ImageView hChattingRomeProfile;//채팅방 프로필 사진

        public MyViewHolder(View v) {
            super(v);
            hChattingListRoomName = v.findViewById(R.id.hChattingListRoomName);
            hChattingListChat = v.findViewById(R.id.hChattingListChat);
            hChattingRomeProfile=v.findViewById(R.id.hChattingRomeProfile);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HChattingListAdapter(List<HChattingListData> myDataset) {
        mDataset = myDataset;
    }
    //MainActivity의 data(myDataset)를 받아서 mDataset에 저장

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        myDataset = new ArrayList<>();
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.h_chatting_list_row, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }//row를 찾는 기능, inflate: xml을 개체로 변환시켜 준 것

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        HChattingListData friend = mDataset.get(position);
        holder.TextView_friendname.setText(friend.getName());
        holder.TextView_info.setText(friend.getInfo());
        // holder.ImageView_friendprofile.setImage(friend.getImage());
    }

    @Override
    public int getItemCount() {
        return mDataset != null ? mDataset.size():0 ;
    }

    public void addChat(HChattingListData friendData){
        mDataset.add(friendData);
        notifyItemInserted(mDataset.size()-1); //데이터 추가
    }

}
