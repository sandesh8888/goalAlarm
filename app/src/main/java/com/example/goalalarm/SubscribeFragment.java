package com.example.goalalarm;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SubscribeFragment extends Fragment {

    View matchesView;
    private RecyclerView recyclerView;
    private MatchesAdapter adapter;

    public SubscribeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Connecting Java Class to layout XML file
        matchesView = inflater.inflate(R.layout.subscribe_fragment,container,false);

        //finding Recycler View
        recyclerView = matchesView.findViewById(R.id.subscribe_recyclerView);

        ////Setting RecyclerView Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        FirebaseRecyclerOptions<MatchesModel> options =
                new FirebaseRecyclerOptions.Builder<MatchesModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("matches"),MatchesModel.class)
                        .build();
        adapter = new MatchesAdapter(options);
        recyclerView.setAdapter(adapter);

        return matchesView;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
