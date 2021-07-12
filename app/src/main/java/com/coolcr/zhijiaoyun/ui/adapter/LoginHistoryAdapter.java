package com.coolcr.zhijiaoyun.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.coolcr.zhijiaoyun.R;
import com.coolcr.zhijiaoyun.base.BaseApplication;
import com.coolcr.zhijiaoyun.model.domain.UserLoginBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoolCrush
 * On 2021/7/12
 * Email CoolCrush@126.com
 */
public class LoginHistoryAdapter extends RecyclerView.Adapter<LoginHistoryAdapter.InnerHolder> {


    private List<UserLoginBean> mData = new ArrayList<>();
    private OnHistoryClickListener mOnHistoryClickListener = null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_history, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mData.get(position));
        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnHistoryClickListener.onRemoveClick(position, mData.get(position));
            }
        });
        holder.tvUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnHistoryClickListener.onTextViewClick(position, mData.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<UserLoginBean> userLoginBeans) {
        mData.clear();
        mData.addAll(userLoginBeans);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView tvUsername;
        private final ImageView imgRemove;
        private final ImageView imgCover;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            imgRemove = itemView.findViewById(R.id.imgRemove);
            imgCover = itemView.findViewById(R.id.imgCover);
        }

        public void setData(UserLoginBean userLoginBean) {
            tvUsername.setText(userLoginBean.getUsername());
            RequestOptions options = new RequestOptions().error(R.mipmap.default_avatar).bitmapTransform(new RoundedCorners(100));
            Glide.with(BaseApplication.getAppContext()).load(userLoginBean.getImgUrl()) //图片地址
                    .apply(options)
                    .into(imgCover);
        }
    }

    public interface OnHistoryClickListener {
        void onTextViewClick(int position, UserLoginBean data);

        void onRemoveClick(int position, UserLoginBean data);
    }

    public void setOnHistoryClickListener(OnHistoryClickListener onHistoryClickListener) {
        mOnHistoryClickListener = onHistoryClickListener;
    }
}
