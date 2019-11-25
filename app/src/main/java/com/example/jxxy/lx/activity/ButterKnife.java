package com.example.jxxy.lx.activity;

import android.view.View;

import com.example.jxxy.lx.R;

import butterknife.OnClick;

public class ButterKnife extends MainActivity{
    @OnClick({R.id.iv_back,R.id.bt_login,R.id.findback,R.id.register})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                break;
            case R.id.bt_login:
                break;
            case R.id.findback:
                break;
            case R.id.register:
                break;
        }
    }
}
