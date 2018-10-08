package inatel.br.kotlinexample.network

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseContract {
  
  protected fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
  }
  
}