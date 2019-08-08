//package com.example.fiba.network.client;
//
//import com.example.fiba.base.BaseClient;
//import com.example.fiba.model.Login;
//import com.example.fiba.network.api.LoginApi;
//import com.example.fiba.network.request.LoginRequest;
//
//import org.json.JSONObject;
//
//import java.util.Objects;
//
//import io.reactivex.Single;
//
//public class LoginClient extends BaseClient<LoginApi> {
//
//    @Override
//    protected Class api() {
//
//        return LoginApi.class;
//    }
//
//    public Single<Login> login(LoginRequest loginRequest) {
//
//        return api.login(loginRequest).map(response -> {
//
//            if (!response.isSuccessful()) {
//
//                JSONObject errorBody = new JSONObject(Objects
//                        .requireNonNull(
//                                response.errorBody()).string());
//
//                throw new Exception(errorBody.getString("message"));
//            }
//
//            if (response.body().getStatus() == 200) {
//
//                Login login = new Login();
//
//                login.setToken(response.body().getData().getToken());
//                login.setRefreshToken(response.body().getData().getRefreshToken());
//                login.setInfo(response.body().getData().getInfo());
//
//                return login;
//            }
//            else if (response.body().getStatus() == 401) {
//
//                throw new Exception("아이디 또는 비밀번호가 틀렸습니다");
//            }
//            else {
//
//                throw new Exception(response.body().getMessage());
//            }
//
//        });
//    }
//}
