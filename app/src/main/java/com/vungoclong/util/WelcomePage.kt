package com.vungoclong.util

import com.vungoclong.R

sealed class WelcomePage(
    val image: Int,
    val content: String
) {
    object First : WelcomePage(
        image = R.drawable.ic_welcome_1,
        content = "Đắm mình trong thế giới truyện đặc sắc"
    )

    object Second : WelcomePage(
        image = R.drawable.ic_welcome_2,
        content = "Truyện mới được cập nhật thường xuyên"
    )

    object Third : WelcomePage(
        image = R.drawable.ic_welcome_3,
        content = "Hoàn toàn miễn phí"
    )
}
