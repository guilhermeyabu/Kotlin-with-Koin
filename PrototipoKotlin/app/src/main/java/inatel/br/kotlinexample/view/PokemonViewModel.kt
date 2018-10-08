package inatel.br.kotlinexample.view

import android.content.Context
import android.util.Log
import android.widget.Toast
import inatel.br.kotlinexample.model.Pokemon
import inatel.br.kotlinexample.network.NetworkViewModel
import inatel.br.kotlinexample.network.PokemonContract
import inatel.br.kotlinexample.util.Logger
import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PokemonViewModel(private val mContext: Context) : NetworkViewModel<List<Pokemon>>(), KoinComponent {
  
  private val TAG = Logger.getTag()
  
  private val mPokemonContract: PokemonContract by inject()
  
  override fun getRequestObservable(): Observable<List<Pokemon>> {
    return mPokemonContract.getPokemons()
  }
  
  override fun onResult(result: List<Pokemon>) {
    Toast.makeText(mContext, "Deu certo!", Toast.LENGTH_LONG).show()
    result.forEach { Log.d(TAG, "The Pokemon is ${it.name}") }
  }
  
  override fun onError(throwable: Throwable) {
    Toast.makeText(mContext, throwable.message, Toast.LENGTH_LONG).show()
    Log.e(TAG, throwable.message)
  }
  
  fun onResume() {
    makeRequest()
  }
}