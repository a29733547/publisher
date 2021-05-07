package com.czerny.publisher.home

import android.os.Parcelable
import android.provider.CalendarContract
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

//與Api設定連動
@Parcelize
data class Product(
    val id: String,
    val title: String,
    val description: String,
    val price: Int,
    val priceStringType: String = "NT$$price", //要加這個顯示NT$
    val texture: String,
    val wash: String,
    val place: String,
    val note: String,
    val story: String,
    val colors: @RawValue List<CalendarContract.Colors>,
    val sizes: List<String>,
//    val variants: @RawValue List<Variant>,
    @Json(name = "main_image")
    val main_image: String,
    val images: List<String>
) : Parcelable {

    /**week 1 part 5 尺寸的cord */
    val detailSize
        get() = if (sizes.size == 1) { //只有一個size時
            sizes[0]
        } else {
            ("${sizes[0]} - ${sizes.last()}")
        }

}


/**提取資料*/
