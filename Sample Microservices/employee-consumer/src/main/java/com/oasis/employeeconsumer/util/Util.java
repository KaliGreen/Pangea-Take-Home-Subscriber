package com.oasis.employeeconsumer.util;

import com.google.gson.Gson;

/**
 * Created by Green on 23/03/2018.
 */


public class Util {

    private static final Gson GSON = new Gson();




    public static <T> T fromJson(String data, Class<T> tClass) {
        return GSON.fromJson(data, tClass);
    }
}
