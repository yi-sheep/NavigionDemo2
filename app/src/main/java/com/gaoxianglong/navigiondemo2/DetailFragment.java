package com.gaoxianglong.navigiondemo2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = getView().findViewById(R.id.textView); // 找到TextView
        // 通过getArguments()获取到数据，当然从navigation添加的数据和使用Bundle传递是数据都可以通过这样获取到
        // 这里要注意如果你在navigation中的碎片上定义了数据然后又在action(连接线)中定义了同样key的数据那么
        // 启动这个碎片的时候会被连接线上的数据覆盖掉
        // 这里获取navigation中的数据
        String str1 = getArguments().getString("name");
        // 这里获取通过Bundle传递是数据
        String str2 = getArguments().getString("MY_NAME");
        textView.setText(str2);
    }
}
