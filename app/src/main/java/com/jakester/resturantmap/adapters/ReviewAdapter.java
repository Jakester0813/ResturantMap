package com.jakester.resturantmap.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakester.resturantmap.R;
import com.jakester.resturantmap.models.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 8/23/2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    List<Review> mReviews;

    public ReviewAdapter(List<Review> reviews){
        this.mReviews = reviews;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_row, parent, false);
        return new ReviewViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        holder.bind(mReviews.get(position));
    }

    @Override
    public int getItemCount() {
        return mReviews.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder{

        TextView mAuthorNameText, mRatingText, mReviewText;

        public ReviewViewHolder(View itemView){
            super (itemView);
            mAuthorNameText = (TextView) itemView.findViewById(R.id.tv_author_name);
            mRatingText = (TextView) itemView.findViewById(R.id.tv_rating);
            mReviewText = (TextView) itemView.findViewById(R.id.tv_review);
        }

        public void bind(Review review){
            StringBuilder sb = new StringBuilder(Integer.toString(review.getRating()));
            sb.append("/5");
            mAuthorNameText.setText(review.getAuthorName());
            mRatingText.setText(sb.toString());
            mReviewText.setText(review.getText());
        }
    }
}
