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
    private ArrayList<HChattingListData> hCLDataset;//HChattinListData 위한 참조변수

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

    public HChattingListAdapter(List<HChattingListData> hCLDataset) {
        hCLADataset = hCLDataset;
    }


    @Override
    public HChattingListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        hCLDataset = new ArrayList<>();
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.h_chatting_list_row, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HChattingListData hCL = hCLADataset.get(position);
        holder.hChattingListChat.setText(hCL.gethLastChat());
        holder.hChattingListRoomName.setText(hCL.gethRoomName());

        String himageString = hCL.gethRoomProfileimageString();// 채팅방 프로필 이미지의 string 정보를 받음
        HBitmapTool hBT = new HBitmapTool();//string을 bitmap으로 전환하기 위한 참조변수 선언
        holder.hChattingRomeProfile.setImageBitmap(hBT.hStringToBitmap(himageString));//bitmap 변환 후 image 세팅
    }

    @Override
    public int getItemCount() {
        return hCLADataset != null ? hCLADataset.size():0 ;
    }

    public void addChat(HChattingListData hCLData){
        hCLADataset.add(hCLData);
        notifyItemInserted(hCLADataset.size()-1); //데이터 추가
    }

}
