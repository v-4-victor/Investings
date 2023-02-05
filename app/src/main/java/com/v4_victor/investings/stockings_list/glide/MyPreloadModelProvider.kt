package com.v4_victor.investings.stockings_list.glide

import android.text.TextUtils
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import java.util.*


class MyPreloadModelProvider(
    private val fragment: Fragment,
    private val myUrls: List<String>,
    private val imageWidthPixels: Int,
    private val imageHeightPixels: Int
) : ListPreloader.PreloadModelProvider<String> {
    override fun getPreloadItems(position: Int): MutableList<String> {
        val url: String = myUrls[position]
        return if (TextUtils.isEmpty(url)) {
            Collections.emptyList()
        } else Collections.singletonList(url)
    }

    override fun getPreloadRequestBuilder(item: String): RequestBuilder<*>? {
        return Glide.with(fragment)
            .load(item)
            .override(imageWidthPixels, imageHeightPixels)    }

}
