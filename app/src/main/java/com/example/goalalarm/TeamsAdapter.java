package com.example.goalalarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class TeamsAdapter extends FirebaseRecyclerAdapter<TeamModel, TeamsAdapter.TeamsViewHolder> {

    public TeamsAdapter(@NonNull FirebaseRecyclerOptions<TeamModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull TeamsViewHolder holder, int position, @NonNull TeamModel model) {


        //Setting
        holder.tv_teamName.setText(model.getTeamName());
        holder.tv_homeLeague.setText(model.getHomeLeague());
        Picasso.get().load(model.getLogo()).resize(100,100).into(holder.img_teamLogo);




    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);

        return new TeamsViewHolder(view);
    }

    class TeamsViewHolder extends RecyclerView.ViewHolder{

        //Creating Reference Variable for textview and Image View used in items_home layout class
        TextView tv_teamName;
        TextView tv_homeLeague;
        ImageView img_teamLogo;

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);
           tv_teamName = itemView.findViewById(R.id.teamname_id);
           tv_homeLeague = itemView.findViewById(R.id.teamleague_id);
           img_teamLogo = itemView.findViewById(R.id.img_teamlogo);
        }
    }
}
