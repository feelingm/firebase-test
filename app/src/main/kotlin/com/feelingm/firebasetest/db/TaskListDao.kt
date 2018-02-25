package com.feelingm.firebasetest.db

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created by mac on 2018. 2. 23..
 */

@Dao
interface TaskListDao {

    @Query("SELECT * FROM tasklist")
    fun list(): Flowable<List<TaskListEntity>>

    @Insert
    fun insert(tasklist: TaskListEntity): Long

    @Delete
    fun delete(tasklist: TaskListEntity): Int

    @Update
    fun update(tasklist: TaskListEntity): Int
}