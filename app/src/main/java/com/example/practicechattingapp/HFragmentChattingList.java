package com.example.practicechattingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HFragmentChattingList extends Fragment {

    private RecyclerView hRecyclerViewChattingList; //채팅목록 recyclerview 참조 변수
    private RecyclerView.LayoutManager hCLLayoutManager;//linearlayout 매니저 참조변수
    private RecyclerView.Adapter hCLAdapter; //adpater 참조변수
    private ArrayList<HChattingListData> hCLFDataset; //채팅방 데이터

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview =(ViewGroup) inflater.inflate(R.layout.h_fragment_chatting_list, container,false);

        hRecyclerViewChattingList = rootview.findViewById(R.id.hRecyclerViewChattingList);
        hRecyclerViewChattingList.setHasFixedSize(true);

        hCLLayoutManager = new LinearLayoutManager(getContext());//layout manager 인스턴스생성 및 context 생성자 호춯
        hRecyclerViewChattingList.setLayoutManager(hCLLayoutManager);

        hCLFDataset = new ArrayList<>();
        hCLFDataset.add(new HChattingListData());

        hCLAdapter = new HChattingListAdapter(hCLFDataset);
        hRecyclerViewChattingList.setAdapter(hCLAdapter);

        FirebaseDatabase hCLdatabase = FirebaseDatabase.getInstance();
        final DatabaseReference hCLRef = hCLdatabase.getReference();

        //HChattingListData HCLdata=new HChattingListData(); //채팅방 데이터 받는 작업 필요

        hCLRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HChattingListData hCL =dataSnapshot.getValue(HChattingListData.class);
                ((HChattingListAdapter)hCLAdapter).addChat(hCL);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return rootview;
    }
}

