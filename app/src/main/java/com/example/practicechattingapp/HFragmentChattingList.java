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

import java.util.ArrayList;

public class HFragmentChattingList extends Fragment {

    private RecyclerView hRecyclerViewChattingList; //채팅목록 recyclerview 참조 변수
    private RecyclerView.LayoutManager hCLLayoutManager;
    private RecyclerView.Adapter hCLAdapter;
    private ArrayList<HChattingListData> hCLFDataset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview =(ViewGroup) inflater.inflate(R.layout.h_fragment_chatting_list, container,false);
        hRecyclerViewChattingList = rootview.findViewById(R.id.hRecyclerViewChattingList);

        hRecyclerViewChattingList.setHasFixedSize(true);

        hCLFDataset = new ArrayList<>();
        hCLFDataset.add(new HChattingListData());

        hCLAdapter = new HChattingListAdapter(hCLFDataset);
        hRecyclerViewChattingList.setAdapter(hCLAdapter);

        return rootview;
    }
}

