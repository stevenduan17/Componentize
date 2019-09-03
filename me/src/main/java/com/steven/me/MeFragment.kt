package com.steven.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.steven.base.ME_FRAGMENT

/**
 * @author Steven
 * @version 1.0
 * @since 2019/9/2
 */
@Route(path = ME_FRAGMENT)
class MeFragment : Fragment() {

    companion object {
        fun getInstance() = MeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.me_fragment_me, container, false)
    }

}