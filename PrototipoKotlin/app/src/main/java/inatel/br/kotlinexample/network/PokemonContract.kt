package inatel.br.kotlinexample.network

import inatel.br.kotlinexample.model.PokemonAux
import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PokemonContract : BaseContract(), KoinComponent {
  
  private val mPokemonRepository : PokemonRepository by inject()
  
  fun getPokemons(): Observable<PokemonAux> {
    return mPokemonRepository.getPokemons().applySchedulers().share()
  }
}