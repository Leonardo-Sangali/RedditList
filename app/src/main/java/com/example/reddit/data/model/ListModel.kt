package com.example.reddit.data.model

data class ListModel(
    val kind: String,
    val data: Data
) {
    data class Data (
       val dist:Int,
       val children: List<Children>

            ){
        data class Children(
            val data: Datas

        ) {
            data class Datas (
                val title: String
                    )
        }

    }
}