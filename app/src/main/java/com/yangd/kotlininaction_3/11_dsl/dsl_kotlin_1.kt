package com.yangd.kotlininaction_3.`11_dsl`

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

fun main(args:Array<String>) {

    println(1.days.ago)
    println(2.days.fromNow)

}

val Int.days:Period
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Period.ofDays(this)

val Period.ago:LocalDate
          @RequiresApi(Build.VERSION_CODES.O)
          get() =LocalDate.now() -this

val Period.fromNow:LocalDate
           @RequiresApi(Build.VERSION_CODES.O)
           get() = LocalDate.now()+this

