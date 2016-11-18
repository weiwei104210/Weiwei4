package com.example.weiwei.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weiwei.util.DataUtils;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("TAG", "DetailFragment onCreateView()");
        //获取内部携带的数据
        Bundle bundle = this.getArguments();
        int position = bundle.getInt("position");

        TextView tv = new TextView(getActivity());
        tv.setText(DataUtils.DETAILS[position]);

        return tv;
    }


}
