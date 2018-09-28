package inatel.br.kotlinexample

import android.app.Application
import inatel.br.kotlinexample.di.retrofit.retrofitProvider
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Start koin
        startKoin(this, retrofitProvider)
    }
}