//package com.example.fiba.base;
//
//import android.util.Log;
//
//import com.example.fiba.utils.Utils;
//
//import org.json.JSONObject;
//
//import java.util.Objects;
//
//import io.reactivex.functions.Function;
//import retrofit2.Response;
//
//public abstract class BaseClient<V> {
//
//    protected V api;
//
//    protected abstract Class api();
//
//    public BaseClient() {
//
//        api = (V) Utils.RETROFIT.create(api());
//    }
//
//    protected <T> Function<retrofit2.Response<Response<T>>, T> getResponseObjectsFunction() {
//
//        return response -> {
//
//            if (!response.isSuccessful()) {
//
//                JSONObject errorBody = new JSONObject(Objects
//                        .requireNonNull(
//                                response.errorBody()).string());
//
//                Log.e("message", errorBody.getString("message"));
//
//                throw new Exception(errorBody.getString("message"));
//            }
//
//            Log.e("message", response.body().getStatus() + "");
//
//            return (T) response.body().getData();
//        };
//    }
//}
