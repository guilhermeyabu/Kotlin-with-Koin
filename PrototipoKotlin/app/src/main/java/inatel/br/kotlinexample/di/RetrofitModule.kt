package inatel.br.kotlinexample.di

import inatel.br.kotlinexample.BuildConfig
import inatel.br.kotlinexample.network.PokemonContract
import inatel.br.kotlinexample.network.PokemonRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
  single { providesRetrofitAdapter() }
  single {  PokemonContract() }
  single {  PokemonRepository(get()) }
}

fun providesRetrofitAdapter(): Retrofit {
  val okHttpClient: OkHttpClient = OkHttpClient().
      newBuilder().
      addInterceptor(HttpLoggingInterceptor().
          setLevel(HttpLoggingInterceptor.Level.BODY)).
      build()
  
  return Retrofit.Builder().
      baseUrl(BuildConfig.API_ENDPOINT).
      client(okHttpClient).
      addConverterFactory(GsonConverterFactory.create()).
      addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
      build()
}

val retrofitProvider = listOf(retrofitModule)
