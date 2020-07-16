package app.shijin.shijinnewsapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import app.shijin.shijinnewsapp.R;
import app.shijin.shijinnewsapp.fragment.Business__News;
import app.shijin.shijinnewsapp.fragment.Entertainment_News;
import app.shijin.shijinnewsapp.fragment.Science_News;
import app.shijin.shijinnewsapp.fragment.Sports_News;
import app.shijin.shijinnewsapp.fragment.Technology_News;
import app.shijin.shijinnewsapp.fragment.Top_Headlines_News;
import app.shijin.shijinnewsapp.fragment.World_News;

public class CustomAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomAdapter(Context mContext, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mContext = mContext;


    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new Top_Headlines_News();
                break;
            case 1:
                fragment = new World_News();
                break;
            case 2:
                fragment = new Technology_News();
                break;
            case 3:
                fragment = new Business__News();
                break;
            case 4:
                fragment = new Science_News();
                break;
            case 5:
                fragment = new Sports_News();
                break;
            case 6:
                fragment = new Entertainment_News();
                break;

            default:
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {

        return 7;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String tabTitleName = null;
        switch (position) {

            case 0:
                tabTitleName = mContext.getString(R.string.tab_headlines);
                break;

            case 1:
                tabTitleName = mContext.getString(R.string.tab_world);
                break;
            case 2:
                tabTitleName = mContext.getString(R.string.tab_technology);
                break;
            case 3:
                tabTitleName = mContext.getString(R.string.tab_business);
                break;
            case 4:
                tabTitleName = mContext.getString(R.string.tab_science);
                break;
            case 5:
                tabTitleName = mContext.getString(R.string.tab_sports);
                break;
            case 6:
                tabTitleName = mContext.getString(R.string.tab_entertainment);
                break;
            default:
                break;
        }

        return tabTitleName;
    }

}
