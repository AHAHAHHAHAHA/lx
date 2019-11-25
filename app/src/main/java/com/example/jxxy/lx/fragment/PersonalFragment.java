package com.example.jxxy.lx.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jxxy.lx.R;
import com.example.jxxy.lx.activity.ChangePwdActivity;
import com.example.jxxy.lx.activity.LoginActivity;
import com.example.jxxy.lx.activity.MainActivity;
import com.example.jxxy.lx.activity.MyAddressActivity;
import com.example.jxxy.lx.activity.MyCollectActivity;
import com.example.jxxy.lx.activity.MyOrderActivity;
import com.example.jxxy.lx.activity.SplashActivity;
import com.example.jxxy.lx.common.BaseActivity;
import com.example.jxxy.lx.common.BaseFragment;
import com.example.jxxy.lx.utils.SystemConfig;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalFragment extends BaseFragment{
    @BindView(R.id.personal_for_login)
    RelativeLayout personal_for_login;
    @BindView(R.id.user_img_view)
    ImageView user_img_view;
    @BindView(R.id.user_name)
    TextView user_name;
    @BindView(R.id.user_level)
    TextView user_level;
    @BindView(R.id.personal_for_not_login)
    RelativeLayout personal_for_not_login;
    @BindView(R.id.personal_logout_layout)
    RelativeLayout personal_logout_layout;
    public int getContentViewId(){
        return R.layout.fragment_personal;
    }
    protected void initView(View view){
        super.initView(view);
        resetUI();
    }
    private void resetUI(){
        if(SystemConfig.isLogin()){
            personal_for_login.setVisibility(View.VISIBLE);
            personal_for_not_login.setVisibility(View.GONE);
            personal_logout_layout.setVisibility(View.VISIBLE);
            ImageLoader.getInstance().displayImage(SystemConfig.getLoginUserHead(),user_img_view);
            user_name.setText(SystemConfig.getLoginUserName());
            user_level.setText(SystemConfig.getLoginUserEmail());
        }else{
            personal_for_login.setVisibility(View.GONE);
            personal_for_not_login.setVisibility(View.VISIBLE);
            personal_logout_layout.setVisibility(View.GONE);
        }
    }
    @OnClick(R.id.personal_login)
    void login(){
        Intent intent=new Intent(getActivity(),LoginActivity.class);
        startActivityForResult(intent,1000);
    }
    @OnClick(R.id.personal_my_order)
    void person_my_order(){
        if(SystemConfig.isLogin()){
            startActivity(new Intent(getActivity(),MyOrderActivity.class));
        }else{
            Intent intent=new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent,1001);
        }
    }
    @OnClick(R.id.my_collect)
    void my_collect(){
        if (SystemConfig.isLogin()){
            startActivity(new Intent(getActivity(),MyCollectActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1002);
        }
    }
    @OnClick(R.id.my_address)
    void my_address(){
        if(SystemConfig.isLogin()){
            startActivity(new Intent(getActivity(), MyAddressActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1003);
        }
    }
    @OnClick(R.id.my_account)
    void my_account(){
        if (SystemConfig.isLogin()){
            startActivity(new Intent(getActivity(), ChangePwdActivity.class));
        }else{
            Intent intent=new Intent(getActivity(),LoginActivity.class);
            startActivityForResult(intent,1004);
        }
    }
    @OnClick(R.id.personal_logout_layout)
    void logout(){
        SystemConfig.logout();
        resetUI();
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode== Activity.RESULT_OK){
            resetUI();
            Intent intent=new Intent();
            if (requestCode==1000){
            }else if(requestCode==1001){
                intent .setClass(getActivity(),MyOrderActivity.class);
                startActivity(intent);
            }else if(requestCode==1002){
                intent.setClass(getActivity(),MyCollectActivity.class);
                startActivity(intent);
            }else if(requestCode==1003){
                intent.setClass(getActivity(),MyAddressActivity.class);
                startActivity(intent);
            }else if(requestCode==1004){
                intent.setClass(getActivity(),ChangePwdActivity.class);
                startActivity(intent);
            }
        }
    }
}