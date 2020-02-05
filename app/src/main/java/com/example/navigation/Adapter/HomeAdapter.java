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
import com.example.navigation.Model.CommonObject;
import com.example.navigation.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private List<CommonObject> commonObjectList;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setCommonObject(List<CommonObject> commonObjectList) {
        this.commonObjectList = commonObjectList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_slider_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if (position == 0) {
        ((ViewHolder) holder).bind(commonObjectList.get(0).getImageList().get(position));
//        }
//        else
//            ((ViewHolderCard) holder).bind(commonObjectList.get(0).getCategoryList().get(position - 1));

    }

    @Override
    public int getItemCount() {
        return commonObjectList != null ? commonObjectList.size() : 0;

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        InnerHomeAdapter innerHomeAdapter = new InnerHomeAdapter(context);
        @BindView(R.id.card_recycler_view)
        RecyclerView recyclerCardView;
        @BindView(R.id.card_view_image_slider)
        ImageView cardViewImageSlider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String s) {
            Glide.with(context)
                    .load(s)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(cardViewImageSlider);
            recyclerCardView.setAdapter(innerHomeAdapter);
            innerHomeAdapter.setList(commonObjectList.get(getAdapterPosition()).getCategoryList());


        }
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) {
//            return 1;
//        } else return 2;
//    }

}


