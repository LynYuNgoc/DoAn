package com.example.musicappdemo2.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicappdemo2.R;

import java.util.List;

public class SearchFilterAdapter extends RecyclerView.Adapter{



    List<SearchFilterItem> searchFilterItems;

    public SearchFilterAdapter(List<SearchFilterItem> searchFilterItems, Context context) {
        this.searchFilterItems = searchFilterItems;
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout_search_filter, parent, false);
        SearchFilterAdapter.SearchFilterViewHolder viewHolder = new SearchFilterAdapter.SearchFilterViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SearchFilterItem searchItem = searchFilterItems.get(position);

        if (searchItem == null){
            return;
        }
        SearchFilterViewHolder searchFilterViewHolder = (SearchFilterViewHolder) holder;
        searchFilterViewHolder.textViewSongName.setText(searchItem.getNameSong());
        searchFilterViewHolder.textViewSingerName.setText(searchItem.getNameSinger());

        searchFilterViewHolder.imageViewSong.setImageBitmap(Utils.loadBitmapFromAssets(context, searchItem.getAvatar(), "default_album_avatar"));

    }

    @Override
    public int getItemCount() {

        if(searchFilterItems != null){
            return searchFilterItems.size();
        }

        return 0;
    }

    public class SearchFilterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewSong;
        private TextView textViewSongName;
        private TextView textViewSingerName;


        public SearchFilterViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSong = itemView.findViewById(R.id.imageViewSearchAvatarSong);
            textViewSongName = itemView.findViewById(R.id.textViewSearchSongName);
            textViewSingerName = itemView.findViewById(R.id.textViewSearchSingerName);
        }
    }
}
