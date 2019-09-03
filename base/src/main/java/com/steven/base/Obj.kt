package com.steven.base

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Steven
 * @version 1.0
 * @since 2019/9/2
 */

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Obj(
    val first: String,
    val second: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(first)
        writeString(second)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Obj> = object : Parcelable.Creator<Obj> {
            override fun createFromParcel(source: Parcel): Obj = Obj(source)
            override fun newArray(size: Int): Array<Obj?> = arrayOfNulls(size)
        }
    }
}