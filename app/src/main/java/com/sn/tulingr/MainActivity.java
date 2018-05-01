package com.sn.tulingr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sn.tulingr.constant.TulingParams;
import com.sn.tulingr.control.RetrofitApi;
import com.sn.tulingr.entity.MessageEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestApiByRetrofit("你好");
    }

    // 请求图灵API接口，发送info,获得问答信息
    private void requestApiByRetrofit(String info){
        //步骤4:创建Retrofit对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(TulingParams.TULING_URL) // 设置 网络请求 Url（Retrofit2.0拥有优秀的拼接功能,而不用自己写拼接方法）
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build(); //自动设置超时为10s，修改则要自己建一个OkHttpClient

        // 步骤5:创建 网络请求接口 的实例
        RetrofitApi api=retrofit.create(RetrofitApi.class);
        //对 发送请求 进行封装
        Call<MessageEntity> call=api.getTuringInfo(TulingParams.TULING_KEY,info);
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<MessageEntity>() {
            //请求成功时候的回调
            @Override
            public void onResponse(Call<MessageEntity> call, Response<MessageEntity> response) {
                response.body().show();//直接在entity中加个show方法来测试
            }

            @Override
            public void onFailure(Call<MessageEntity> call, Throwable t) {
                System.out.println("连接失败");
            }
        });
    }
}
