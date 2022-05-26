package com.vungoclong.util

object Helper {
    fun categoryArrayToString(categorys: ArrayList<String>): String {
        var result = ""
        categorys.forEach {
            result += "$it, "
        }
        return result.substring(0, result.length - 2)
    }
}