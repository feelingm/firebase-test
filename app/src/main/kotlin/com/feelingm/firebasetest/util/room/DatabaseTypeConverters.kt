package com.feelingm.firebasetest.util.room

import android.arch.persistence.room.TypeConverter
import com.google.api.client.util.DateTime

/**
 * Created by mac on 2018. 2. 23..
 */

class DatabaseTypeConverters {

    @TypeConverter
    fun dateTimeToString(dateTime: DateTime): String =
            dateTime.toStringRfc3339()

    @TypeConverter
    fun stringToDateTime(dateTime: String): DateTime =
            DateTime.parseRfc3339(dateTime)
}