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

public class MatchesAdapter extends FirebaseRecyclerAdapter<MatchesModel, MatchesAdapter.MatchViewHolder> {


    public MatchesAdapter(@NonNull FirebaseRecyclerOptions<MatchesModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MatchViewHolder holder, int position, @NonNull MatchesModel model) {
        holder.tv_matchDate.setText(model.getDate());
        holder.tv_matchTime.setText(model.getTime());
        holder.tv_matchLeague.setText(model.getLeague());
        holder.tv_homeTeamName.setText(model.getHomeTeamName());
        holder.tv_awayTeamName.setText(model.getAwayTeamName());
        Picasso.get().load(model.getHomeTeamLogo()).resize(100,100).into(holder.tv_homeTeamImg);
        Picasso.get().load(model.getAwayTeamLogo()).resize(100,100).into(holder.tv_awayTeamImg);

    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subscribe,parent,false);

        return new MatchViewHolder(view);
    }

    class  MatchViewHolder extends RecyclerView.ViewHolder{

        TextView tv_matchDate;
        TextView tv_matchTime;
        TextView tv_matchLeague;
        TextView tv_homeTeamName;
        TextView tv_awayTeamName;
        ImageView tv_homeTeamImg;
        ImageView tv_awayTeamImg;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_matchDate = itemView.findViewById(R.id.matchdate_id);
            tv_matchTime = itemView.findViewById(R.id.matchtime_id);
            tv_homeTeamName = itemView.findViewById(R.id.hometeamname_id);
            tv_matchLeague = itemView.findViewById(R.id.league_id);
            tv_awayTeamName = itemView.findViewById(R.id.awayteamname_id);
            tv_homeTeamImg = itemView.findViewById(R.id.hometeamlogo_id);
            tv_awayTeamImg = itemView.findViewById(R.id.awayteamlogo_id);
        }
    }
}
