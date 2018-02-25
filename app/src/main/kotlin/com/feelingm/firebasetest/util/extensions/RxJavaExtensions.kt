package com.feelingm.firebasetest.util.extensions

import com.feelingm.firebasetest.util.lifecycle.AutoClearedDisposable
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

operator fun AutoClearedDisposable.plusAssign(disposable: Disposable)
        = this.add(disposable)

fun runOnIoScheduler(func: () -> Unit): Disposable
        = Completable.fromCallable(func).subscribeOn(Schedulers.io()).subscribe()

fun <T> executeHttpRequest(func: () -> T): Flowable<T>
        = Flowable.fromCallable(func)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())