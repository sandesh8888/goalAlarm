package com.example.goalalarm;

import android.content.Context;
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

public class NewsAdapter extends FirebaseRecyclerAdapter<NewsModel, NewsAdapter.NewsViewHolder> {

    private Context context;


    public NewsAdapter(@NonNull FirebaseRecyclerOptions<NewsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NewsViewHolder holder, final int position, @NonNull NewsModel model) {
        holder.tv_newsTitle.setText(model.getNewsTitle());
        holder.tv_newsDescription.setText(model.getNewsDescription());
        Picasso.get().load(model.getNewsImage()).resize(200,200).into(holder.tv_newsImage);
        holder.tv_newsPostedDate.setText(model.getNewsPostedDate());
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latest,parent,false);
        return new NewsViewHolder(view);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView tv_newsTitle;
        TextView tv_newsDescription;
        ImageView tv_newsImage;
        TextView tv_newsPostedDate;
        View v;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_newsTitle = itemView.findViewById(R.id.newstitle_id);
            tv_newsDescription = itemView.findViewById(R.id.newsdesc_id);
            tv_newsImage = itemView.findViewById(R.id.newsimg_id);
            tv_newsPostedDate = itemView.findViewById(R.id.newsdate_id);
            v=itemView;

        }
    }
}
