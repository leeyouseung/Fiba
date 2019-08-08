//package com.example.fiba.viewmodel;
//
//import android.content.Context;
//
//import com.example.fiba.base.BaseViewModel;
//import com.example.fiba.model.Login;
//import com.example.fiba.network.client.LoginClient;
//import com.example.fiba.network.request.LoginRequest;
//
//public class LoginViewModel extends BaseViewModel<Login> {
//
//    private LoginClient loginClient;
//
//    public LoginViewModel(Context context) {
//        super(context);
//        loginClient = new LoginClient();
//    }
//
//    public void login(LoginRequest loginRequest) {
//
//        addDisposable(loginClient.login(loginRequest), getDataObserver());
//    }
//}
