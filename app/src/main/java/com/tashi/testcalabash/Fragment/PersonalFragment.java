package com.tashi.testcalabash.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tashi.testcalabash.R;

/**
 * Created by SmartTahi on 2018/2/27.
 *
 */

public class PersonalFragment extends Fragment {
    private ImageView avator;
    private TextView username;
    private TextView rank;
    private TextView following_num;
    private TextView followed_num;
    private Activity mActivity;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.personal_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mActivity = this.getActivity();
        findViews();

    }

    public void findViews(){
        this.avator = mActivity.findViewById(R.id.avator);
        this.username = mActivity.findViewById(R.id.username);
        this.rank = mActivity.findViewById(R.id.rank);
        this.following_num = mActivity.findViewById(R.id.following_num);
        this.followed_num = mActivity.findViewById(R.id.followed_num);
    }
}
