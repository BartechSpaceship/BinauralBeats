package com.example.therealbinauralexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondPageBinauralBeatAdapter extends RecyclerView.Adapter<SecondPageBinauralBeatAdapter.SecondPageViewHolder> {

    private ArrayList<SecondPageItem> mSecondPageItemList;

    public static class SecondPageViewHolder extends RecyclerView.ViewHolder {
        public ImageView mSecondImage;
        public TextView mSecondTextTitle;
        public TextView mSecondTextDiscription;

        public SecondPageViewHolder(View itemView){
            super(itemView);
            mSecondImage = itemView.findViewById(R.id.second_page_imageView);
            mSecondTextTitle = itemView.findViewById(R.id.second_page_textViewTitle);
            mSecondTextDiscription = itemView.findViewById(R.id.second_page_textViewDiscription);

        }

    }
    public SecondPageBinauralBeatAdapter(ArrayList<SecondPageItem> secondPageItemList){
        mSecondPageItemList = secondPageItemList;
    }

    @NonNull
    @Override
    public SecondPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_page_card_view, parent, false);
        SecondPageViewHolder spvh = new SecondPageViewHolder(v);
        return spvh;

    }

    @Override
    public void onBindViewHolder(@NonNull SecondPageViewHolder holder, int position) {
        SecondPageItem currentItem = mSecondPageItemList.get(position);

        holder.mSecondImage.setImageResource(currentItem.getSecondPageImage());
        holder.mSecondTextTitle.setText(currentItem.getSecondPageTitle());
        holder.mSecondTextDiscription.setText(currentItem.getSecondPageDiscription());


    }



    @Override
    public int getItemCount() {
        return mSecondPageItemList.size();
    }
}
