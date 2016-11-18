package com.example.weiwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.weiwei.R;
import com.example.weiwei.fragment.DetailFragment;
import com.example.weiwei.util.DataUtils;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class ItemFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //ListView装载数据显示
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, DataUtils.TITLES));

        //设置默认选中第一项
        getListView().setItemChecked(0, true);
        showDetails(0);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        showDetails(position);

        Log.e("TAG", "commit");
    }
    private void showDetails(int position) {
        DetailFragment detailFragment = new DetailFragment();

        //给detailFragment设置参数，即为携带数据
        Bundle bundle = new Bundle();//内部提供了HashMap，用于盛装数据
        bundle.putInt("position",position);//携带点击项的position
        detailFragment.setArguments(bundle);

        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ll_main,detailFragment);

        transaction.commit();
    }

}
