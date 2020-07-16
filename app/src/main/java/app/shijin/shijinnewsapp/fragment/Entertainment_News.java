package app.shijin.shijinnewsapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import app.shijin.shijinnewsapp.NewsDetails;
import app.shijin.shijinnewsapp.R;
import app.shijin.shijinnewsapp.adapter.NewsAdapter;
import app.shijin.shijinnewsapp.adapter.RecyclerTouchListener;
import app.shijin.shijinnewsapp.model.NewsArticles;
import app.shijin.shijinnewsapp.model.NewsInfo;
import app.shijin.shijinnewsapp.util.APIClientSIde;
import app.shijin.shijinnewsapp.util.APIResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static app.shijin.shijinnewsapp.model.Constants.API_KEY;
import static app.shijin.shijinnewsapp.model.Constants.COUNTRY;
import static app.shijin.shijinnewsapp.model.Constants.ENTERTAINMENT;

public class Entertainment_News extends androidx.fragment.app.Fragment implements SwipeRefreshLayout.OnRefreshListener {

    View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<NewsInfo> newsArrayList = new ArrayList<>();
    private NewsAdapter mAdapter;
    private RecyclerView recyclerView;

    public Entertainment_News() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.news_fragment_items, container, false);
        initViews();

        return view;
    }

    private void initViews() {


        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorGreen,
                R.color.colorBlue,
                R.color.colorOrange);
        loadJSON();
        recyclerView = view.findViewById(R.id.simpleRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NewsInfo news = newsArrayList.get(position);
                Intent title_Intent = new Intent(getActivity(), NewsDetails.class);
                title_Intent.putExtra("url", news.getNewsUrl());
                startActivity(title_Intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void loadJSON() {
        swipeRefreshLayout.setRefreshing(true);


        APIResponse request = APIClientSIde.getApiService();

        Call<NewsArticles> call = request.getCategoryOfHeadlines(COUNTRY, ENTERTAINMENT, API_KEY);
        call.enqueue(new Callback<NewsArticles>() {

            @Override
            public void onResponse(Call<NewsArticles> call, Response<NewsArticles> response) {

                if (response.isSuccessful() && response.body().getArticles() != null) {
                    swipeRefreshLayout.setRefreshing(false);
                    if (!newsArrayList.isEmpty()) {
                        newsArrayList.clear();
                    }

                    newsArrayList = response.body().getArticles();
                    mAdapter = new NewsAdapter(newsArrayList);
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<NewsArticles> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(), "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        loadJSON();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
