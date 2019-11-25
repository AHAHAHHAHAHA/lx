package com.example.jxxy.lx.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jxxy.lx.R;
import com.example.jxxy.lx.common.BaseActivity;
import com.example.jxxy.lx.http.ProgressDialogSubscriber;
import com.example.jxxy.lx.http.entity.MemberEntity;
import com.example.jxxy.lx.http.presenter.MemberPresenter;
import com.example.jxxy.lx.utils.SystemConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity{
   @BindView(R.id.et_username)
   EditText etUsername;
   @BindView(R.id.et_pwd)
   EditText etPwd;
   public int getContentViewId(){
      return R.layout.activity_login;
   }
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ButterKnife.bind(this);
   }
   @OnClick(R.id.iv_back)
   void close(){
      finish();
   }
   @OnClick(R.id.bt_login)
   void login(){
      String userName=etUsername.getText().toString().trim();
      String pwd=etPwd.getText().toString().trim();
      if(TextUtils.isEmpty(userName)){
         toastShort("请输入用户名");
         return;
      }
      if (TextUtils.isEmpty(pwd)){
         toastShort("请输入密码");
         return;
      }
      MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this){
         public void onNext(MemberEntity memberEntity){
            SystemConfig.setLogin(true);
            toastShort("登录成功");
            SystemConfig.setLoginUserName(memberEntity.uname);
            SystemConfig.setLoginUserEmail(memberEntity.email);
            SystemConfig.setLoginUserHead(memberEntity.image);
            setResult(RESULT_OK);
            finish();
         }
      },userName,pwd);
   }
}