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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeFragment extends Fragment {

    View teamView;
    private RecyclerView recyclerView;
    private DatabaseReference teamsRef;
    TeamsAdapter adapter;


    //Default Constructor
    public HomeFragment(){


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Connecting Java Class to layout XML file
        teamView= inflater.inflate(R.layout.home_fragment,container,false);

        //finding Recycler View
        recyclerView = teamView.findViewById(R.id.home_recyclerview);

        //Setting RecyclerView Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<TeamModel> options =
                new FirebaseRecyclerOptions.Builder<TeamModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("teams"),TeamModel.class)
                .build();

        adapter = new TeamsAdapter(options);
        recyclerView.setAdapter(adapter);
        return teamView;
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
