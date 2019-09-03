package com.steven.base

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author Steven
 * @version 1.0
 * @since 2019/9/3
 */
interface HelloService : IProvider {
    fun getName(): String
}