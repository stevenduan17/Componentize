package com.steven.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.steven.base.*
import kotlinx.android.synthetic.main.home_fragment_home.*


/**
 * @author Steven
 * @version 1.0
 * @since 2019/8/30
 */
@Route(path = HOME_FRAGMENT)
class HomeFragment : Fragment() {

    companion object {
        fun getInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeText.setOnClickListener {
            ARouter.getInstance()
                .build(EXPLORE_TEST)
                .withString("msg", "This is params from Home.")
                .withParcelable("obj", Obj("haha", "HeiHei"))
                .withObject("object", TestObject("Hello", "World"))
                .withObject("test", TestObj("kotlin", "Object"))
                .navigation()
        }

        val helloService = ARouter.getInstance().build(HELLO_SERVICE).navigation() as HelloService
        Log.d("ARouter", "service by name: ${helloService.getName()}")

        val name = ARouter.getInstance().navigation(HelloService::class.java).getName()
        Log.d("ARouter", "service by type: $name")
    }
}