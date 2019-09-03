package com.steven.explore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.steven.base.EXPLORE_TEST
import com.steven.base.Obj
import com.steven.base.TestObj
import com.steven.base.TestObject
import kotlinx.android.synthetic.main.explore_activity_explore_test.*

@Route(path = EXPLORE_TEST)
class ExploreTestActivity : AppCompatActivity() {

    @Autowired
    @JvmField
    var obj: Obj? = null

    @Autowired(name = "msg")
    @JvmField
    var string: String = ""

    @Autowired(name = "object")
    @JvmField
    var testObj: TestObject? = null

    @Autowired(name = "test")
    @JvmField
    var test: TestObj? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explore_activity_explore_test)
        ARouter.getInstance().inject(this)

        message.text =
            "$string \n ${obj?.first}:${obj?.second} \n ${testObj?.f},${testObj?.s} \n ${test?.f},${test?.s} "
    }
}
