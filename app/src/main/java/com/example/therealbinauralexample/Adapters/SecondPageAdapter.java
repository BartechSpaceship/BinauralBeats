package com.example.therealbinauralexample.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therealbinauralexample.R;
import com.example.therealbinauralexample.Items.SecondPageItem;

import java.util.ArrayList;

public class SecondPageAdapter extends RecyclerView.Adapter<SecondPageAdapter.SecondPageViewHolder> {

    private ArrayList<SecondPageItem> mSecondPageItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener { void onItemClick(int position);}
    public void setOnItemClickListener(OnItemClickListener listener) { mListener = listener; }

    public static class SecondPageViewHolder extends RecyclerView.ViewHolder {
        public ImageView mSecondImage;
        public TextView mSecondTextTitle;
        public TextView mSecondTextDiscription;

        public SecondPageViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            mSecondImage = itemView.findViewById(R.id.second_page_imageView);
            mSecondTextTitle = itemView.findViewById(R.id.second_page_textViewTitle);
            mSecondTextDiscription = itemView.findViewById(R.id.second_page_textViewDiscription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }

                }
            });

        }

    }
    public SecondPageAdapter(ArrayList<SecondPageItem> secondPageItemList){
        mSecondPageItemList = secondPageItemList;
    }

    @NonNull
    @Override
    public SecondPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_page_card_view, parent, false);
        SecondPageViewHolder spvh = new SecondPageViewHolder(v, mListener);
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
