package com.feelingm.firebasetest.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.api.client.util.DateTime
import com.google.api.services.tasks.model.TaskList
import com.google.api.services.tasks.model.TaskLists

/**
 * Created by mac on 2018. 2. 23..
 */

data class TaskListsEntity(var etag: String?,
                           var items: List<TaskListEntity>?,
                           var kind: String? = "tasks#taskLists",
                           var nextPageToken: String?) {
    fun toDto(): TaskLists = TaskLists().let {
        it.etag = etag
        it.items = items?.map { it.toDto() }
        it.kind = kind
        it.nextPageToken = nextPageToken

        it
    }
}

@Entity(tableName = "tasklist")
data class TaskListEntity(
        @ColumnInfo(name = "etag") var etag: String?,
        @ColumnInfo(name = "id") @PrimaryKey var id: String,
        @ColumnInfo(name = "kind") var kind: String? = "tasks#taskList",
        @ColumnInfo(name = "selflink") var selfLink: String?,
        @ColumnInfo(name = "title") var title: String?,
        @ColumnInfo(name = "updated") var updated: DateTime?) {
    fun toDto(): TaskList = TaskList().let {
        it.etag = etag
        it.etag = etag
        it.id = id
        it.kind = kind
        it.selfLink = selfLink
        it.title = title
        it.updated = updated

        it
    }
}

fun TaskList.toEntity(): TaskListEntity = TaskListEntity(
        etag = etag,
        id = id,
        kind = kind,
        selfLink = selfLink,
        title = title,
        updated = updated)

fun TaskLists.toEntity(): TaskListsEntity = TaskListsEntity(
        etag = etag,
        kind = kind,
        nextPageToken = nextPageToken,
        items = items?.map { it.toEntity() })