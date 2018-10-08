package inatel.br.kotlinexample.network

import android.databinding.BaseObservable
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.Consumer

abstract class NetworkViewModel<T> : BaseObservable() {
  
  private val TAG = "NetworkViewModel"
  
  /**
   * Shows the loading screen and subscribe to the [Observable] which will receive the
   * response (success or failure).
   */
  protected fun makeRequest() {
    getRequestObservable().subscribe(Consumer<T> { this.setResult(it) }, Consumer<Throwable> { this.handleError(it) })
  }
  
  /**
   * Shows the loading screen and subscribe to the observable param which will receive the
   * response (success or failure).
   */
  protected fun makeRequest(observable: Observable<T>) {
    observable.subscribe(Consumer<T> { this.setResult(it) }, Consumer<Throwable> { this.handleError(it) })
  }
  
  private fun setResult(result: T) {
    Log.d(TAG, "setResult")
    onResult(result)
  }
  
  private fun handleError(throwable: Throwable) {
    Log.d(TAG, "handleError" + throwable.message)
    onError(throwable)
  }
  
  /**
   * Get the [Observable] related to the ViewModel action flow.
   *
   * @return observable to be executed and subscribed.
   */
  abstract fun getRequestObservable(): Observable<T>
  
  /**
   * Method called when the [Observable] execution was successful.
   *
   * @param result result from observable.
   */
  abstract fun onResult(result: T)
  
  /**
   * Method called when the {@Link Observable} execution was unsuccessful.
   *
   * @param throwable result from observable.
   */
  abstract fun onError(throwable: Throwable)
}