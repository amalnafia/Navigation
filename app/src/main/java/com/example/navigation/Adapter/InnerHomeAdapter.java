package com.example.navigation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.navigation.Model.CategoryDataModelResponse;
import com.example.navigation.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InnerHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryDataModelResponse> list;
    private Context context;

    public InnerHomeAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<CategoryDataModelResponse> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new ViewHolderCard(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderCard) holder).bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolderCard extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view_image)
        ImageView cardViewImage;
        @BindView(R.id.card_view_image_title)
        TextView cardViewTitle;

        public ViewHolderCard(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(CategoryDataModelResponse categoryDataModelResponse) {
            cardViewTitle.setText(categoryDataModelResponse.getCategoryNameEn());
            Glide.with(context)
                    .load(categoryDataModelResponse.getCategoryImageOriginal())
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(cardViewImage);
        }
    }
}