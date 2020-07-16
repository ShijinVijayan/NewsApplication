package app.shijin.shijinnewsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.shijin.shijinnewsapp.R;
import app.shijin.shijinnewsapp.model.NewsInfo;

import static app.shijin.shijinnewsapp.model.NewsInfo.NEWS_IMAGE_TYPE;
import static app.shijin.shijinnewsapp.model.NewsInfo.NEWS_NO_IMAGE_TYPE;


public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NewsInfo> newsList;

    public NewsAdapter(List<NewsInfo> newsList) {
        this.newsList = newsList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case NEWS_IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
                return new NewsWithImageViewHolder(view);
            case NEWS_NO_IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_no_image, parent, false);
                return new NewsWithOutImageViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsInfo news = newsList.get(position);

        switch (news.getType()) {
            case NEWS_IMAGE_TYPE:
                ((NewsWithImageViewHolder) holder).newsTextView.setText(news.getNewstitle());
                Picasso.get()
                        .load(news.getNewsUrlToImage())
                        .resize(200, 200)
                        .centerCrop()
                        .into(((NewsWithImageViewHolder) holder).newsImageView);
                break;
            case NEWS_NO_IMAGE_TYPE:
                ((NewsWithOutImageViewHolder) holder).tv_news_item.setText(news.getNewstitle());
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {

        NewsInfo news = newsList.get(position);
        if (news != null) {
            return news.getType();
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    private class NewsWithImageViewHolder extends RecyclerView.ViewHolder {

        TextView newsTextView;
        ImageView newsImageView;

        public NewsWithImageViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTextView = itemView.findViewById(R.id.titleTextView);
            newsImageView = itemView.findViewById(R.id.urlToImageView);
        }
    }


    private class NewsWithOutImageViewHolder extends RecyclerView.ViewHolder {
        TextView tv_news_item;

        public NewsWithOutImageViewHolder(View view) {
            super(view);
            tv_news_item = (TextView) view.findViewById(R.id.news_textView);
        }
    }
}
