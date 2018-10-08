package inatel.br.kotlinexample.network

import inatel.br.kotlinexample.model.Pokemon
import io.reactivex.Observable
import retrofit2.Retrofit

class PokemonRepository(retrofit: Retrofit){
  
  private var mPokemonService : PokemonService = retrofit.create(PokemonService::class.java)
  
  fun getPokemons(): Observable<List<Pokemon>> {
    return mPokemonService.list()
  }
}