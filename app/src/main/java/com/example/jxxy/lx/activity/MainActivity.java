package com.example.jxxy.lx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.jxxy.lx.R;
import com.example.jxxy.lx.common.BaseActivity;
import com.example.jxxy.lx.fragment.NavigationFragment;
import com.example.jxxy.lx.fragment.PersonalFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{
    public @LayoutRes
    int getContentViewId(){
        return R.layout.activity_main;
    }
  protected void initView(){
        super.initView();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.f1_main,new NavigationFragment());
        //transaction.replace(R.id.bt_login,new PersonalFragment());
        transaction.commit();
    }
}

