package com.example.shujaat_macbook.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdaptor extends RecyclerView.Adapter<ProductAdaptor.ProductViewHolder> {

    private Context mCtx;
    private List<Product> mProductsList;

    public ProductAdaptor(Context ctx, List<Product> productsList)
    {
        mCtx = ctx;
        mProductsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_item, null);
        ProductViewHolder holder = new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i)
    {
        Product prod = mProductsList.get(i);
        productViewHolder.mTextViewTitle.setText(prod.getTitle());
        productViewHolder.mTextViewDesc.setText(prod.getShortdesc());
        productViewHolder.mTextViewRating.setText(String.valueOf(prod.getRating()));
        productViewHolder.mTextViewPrice.setText(String.valueOf(prod.getPrice()));
        productViewHolder.mImageView.setImageDrawable(mCtx.getResources().getDrawable(prod.getImage()));
    }

    @Override
    public int getItemCount()
    {
        return mProductsList.size();
    }

    public class  ProductViewHolder extends RecyclerView.ViewHolder
    {
        ImageView mImageView;
        TextView mTextViewTitle, mTextViewDesc, mTextViewPrice, mTextViewRating;

        public ProductViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mImageView      = itemView.findViewById(R.id.imageView);
            mTextViewTitle  = itemView.findViewById(R.id.textViewTitle);
            mTextViewDesc   = itemView.findViewById(R.id.textViewShortDesc);
            mTextViewPrice  = itemView.findViewById(R.id.textViewRating);
            mTextViewRating = itemView.findViewById(R.id.textViewRating);

        }
    }
}
