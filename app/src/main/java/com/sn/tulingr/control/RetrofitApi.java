package com.sn.tulingr.control;

import com.sn.tulingr.entity.MessageEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by John on 2018/4/30.
 */
public interface RetrofitApi {
    // 请求图灵API接口，获得问答信息
    @GET("api")
    Call<MessageEntity> getTuringInfo(@Query("key") String key,@Query("info") String info);

}
