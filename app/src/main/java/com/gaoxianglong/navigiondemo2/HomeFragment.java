package com.gaoxianglong.navigiondemo2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView()  // 获取到当前碎片的根布局
                .findViewById(R.id.button)  // 在根布局中找到按钮
                .setOnClickListener(v -> {
                    EditText editText = getView().findViewById(R.id.editText); // 找到输入框
                    String name = editText.getText().toString().trim(); // 获取到输入框的内容
                    if (name.isEmpty()) {
                        // 如果没有输入就提示并跳出点击事件
                        Toast.makeText(getActivity(),"请输入名字",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Bundle bundle = new Bundle(); // 实例化一个Bundle用来传递数据
                    bundle.putString("MY_NAME",name); // 包装数据
                    NavController controller = Navigation.findNavController(v);
                    // 这里可以传入你要切换到的那个碎片的id当然推荐还是使用action的id
                    // 原因呢就是可以实现很多的功能比如传递数据
                    // 第二个参数接收一个Bundle包装的数据
                    controller.navigate(R.id.action_homeFragment_to_detailFragment,bundle);
                });
    }
}
