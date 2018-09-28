package inatel.br.kotlinexample

import android.app.Application
import inatel.br.kotlinexample.di.fragmentProvider
import inatel.br.kotlinexample.di.retrofitProvider
import inatel.br.kotlinexample.di.viewModelProvider
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
  
  override fun onCreate() {
    super.onCreate()
    
    //Start koin
    startKoin(this, retrofitProvider + viewModelProvider + fragmentProvider)
  }
}