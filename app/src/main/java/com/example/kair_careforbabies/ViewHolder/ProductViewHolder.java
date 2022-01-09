package com.example.kair_careforbabies.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kair_careforbabies.Interface.ItemClickListener;
import com.example.kair_careforbabies.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView productNametxt, productDescriptiontxt, productPricetxt;
    public ImageView imageView;
    public ItemClickListener listner;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.productImage);
        productNametxt = (TextView) itemView.findViewById(R.id.productName);
        productDescriptiontxt = (TextView) itemView.findViewById(R.id.productDescription);
        productPricetxt = (TextView) itemView.findViewById(R.id.productPrice);
    }
    public void setItemClickListner(ItemClickListener listner)
    {
        this.listner = listner;
    }
    @Override
    public void onClick(View view) {
        listner.onClick(view, getAdapterPosition(), false);
    }
}
