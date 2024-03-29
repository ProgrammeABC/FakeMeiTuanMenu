package cn.edu.ntit.fakemeituanmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;

import java.io.Serializable;
import java.util.List;

public class RightFragment extends Fragment {
    private ListView lv_list;
    public RightFragment(){

    }
    public RightFragment getInstance(List<FoodBean> list){
        RightFragment rightFragment = new RightFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list",(Serializable) list);
        rightFragment.setArguments(bundle);
        return rightFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right,container,false);
        lv_list = view.findViewById(R.id.lv_list);
        if(getArguments()!=null){
            List<FoodBean> list = (List<FoodBean>) getArguments().getSerializable("list");
            RightAdapter adapter = new RightAdapter(getActivity(),list);
            lv_list.setAdapter(adapter);
        }
        return view;
    }
}
