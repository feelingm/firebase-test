package com.feelingm.firebasetest.api

import com.feelingm.firebasetest.db.TaskListEntity
import com.feelingm.firebasetest.db.TaskListsEntity
import com.feelingm.firebasetest.db.toEntity
import com.feelingm.firebasetest.util.extensions.executeHttpRequest
import com.google.api.services.tasks.Tasks
import io.reactivex.Flowable

/**
 * Created by mac on 2018. 2. 23..
 */

class TaskListApi(val tasks: Tasks) {

    fun list(): Flowable<TaskListsEntity> =
            executeHttpRequest { tasks.tasklists().list().execute().toEntity() }

    fun insert(content: TaskListEntity): Flowable<TaskListEntity> =
            executeHttpRequest { tasks.tasklists().insert(content.toDto()).execute().toEntity() }

    fun delete(tasklist: String): Flowable<Any> =
            executeHttpRequest { tasks.tasklists().delete(tasklist).execute() }

    fun patch(tasklist: String, content: TaskListEntity): Flowable<Any> =
            executeHttpRequest { tasks.tasklists().patch(tasklist, content.toDto()).execute() }

}