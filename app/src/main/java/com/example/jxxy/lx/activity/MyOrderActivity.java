package com.example.jxxy.lx.activity;

import android.widget.TextView;

import com.example.jxxy.lx.R;
import com.example.jxxy.lx.common.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyOrderActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    public int getContentViewId(){
        return R.layout.activity_my_order;
    }
    protected void initView(){
        super.initView();
        tvTitle.setText("我的订单");
    }
    @OnClick(R.id.iv_back)
    void close() {
        finish();
    }
}
