package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val stringResourceId: Int,
    val numCourses: Int,
    @DrawableRes val imageResourceId: Int,

)
