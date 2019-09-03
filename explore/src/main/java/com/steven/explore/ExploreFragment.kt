package com.steven.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.steven.base.EXPLORE_FRAGMENT

/**
 * @author Steven
 * @version 1.0
 * @since 2019/9/2
 */
@Route(path = EXPLORE_FRAGMENT)
class ExploreFragment : Fragment() {

    companion object {
        fun getInstance() = ExploreFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.explore_fragment_explore, container, false)
    }
}