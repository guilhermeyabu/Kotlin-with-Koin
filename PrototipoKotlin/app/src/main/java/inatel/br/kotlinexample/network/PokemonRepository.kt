package inatel.br.kotlinexample.network

import inatel.br.kotlinexample.model.PokemonAux
import io.reactivex.Observable
import retrofit2.Retrofit

class PokemonRepository(retrofit: Retrofit){
  
  private var mPokemonService : PokemonService = retrofit.create(PokemonService::class.java)
  
  fun getPokemons(): Observable<PokemonAux> {
    return mPokemonService.list()
  }
}