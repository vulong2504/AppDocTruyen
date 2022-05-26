package com.vungoclong.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vungoclong.R


val poppins_fonts = FontFamily(
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_light, weight = FontWeight.Light),

    )
val literata_fonts = FontFamily(
    Font(R.font.literata_bold, weight = FontWeight.Bold),
    Font(R.font.literata_medium, weight = FontWeight.Medium),
    Font(R.font.literata_light, weight = FontWeight.Light),
)

val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontFamily = poppins_fonts
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        fontFamily = poppins_fonts
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        fontFamily = poppins_fonts
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 19.sp,
        fontFamily = poppins_fonts
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        fontFamily = poppins_fonts
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        fontFamily = poppins_fonts,
    ),
)