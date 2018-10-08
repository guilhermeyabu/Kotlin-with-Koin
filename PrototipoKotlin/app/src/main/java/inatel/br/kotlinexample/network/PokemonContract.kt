package inatel.br.kotlinexample.network

import inatel.br.kotlinexample.model.Pokemon
import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PokemonContract : BaseContract(), KoinComponent {
  
  private val mPokemonRepository : PokemonRepository by inject()
  
  fun getPokemons(): Observable<List<Pokemon>> {
    return mPokemonRepository.getPokemons()
  }
}