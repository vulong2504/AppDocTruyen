package com.vungoclong.model


data class Book(
    var id: String?=null,
    var name: String?=null,
    var author: String?=null,
    var description: String?=null,
    var imageUrl: String?=null,
    var category: ArrayList<String>?=null,
    var chapterNumber: Int?=null,
)

data class Chapters(
    var id: String,//nameBook
    var listChapter: ArrayList<Chapter>,
)

data class Chapter(
    var idChapter: String,//nameBook_chapterNumber
    var name: String,
    var content: String,
)

