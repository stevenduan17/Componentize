package com.steven.base

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * @author Steven
 * @version 1.0
 * @since 2019/9/3
 */

@Route(path = "/service/json")
class JsonServiceImpl : SerializationService {

    private lateinit var GSON: Gson

    override fun init(context: Context?) {
        GSON = Gson()
    }

    override fun <T> json2Object(input: String?, clazz: Class<T>?): T {
        return GSON.fromJson(input, clazz)
    }

    override fun object2Json(instance: Any?): String {
        return GSON.toJson(instance)
    }

    override fun <T> parseObject(input: String?, clazz: Type?): T {
        return GSON.fromJson(input, clazz)
    }
}