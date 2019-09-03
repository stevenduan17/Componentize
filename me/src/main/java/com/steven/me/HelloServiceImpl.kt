package com.steven.me

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.steven.base.HELLO_SERVICE
import com.steven.base.HelloService

/**
 * @author Steven
 * @version 1.0
 * @since 2019/9/3
 */
@Route(path = HELLO_SERVICE)
class HelloServiceImpl : HelloService {

    override fun init(context: Context?) {
    }

    override fun getName(): String {
        return "Hello from Service."
    }
}