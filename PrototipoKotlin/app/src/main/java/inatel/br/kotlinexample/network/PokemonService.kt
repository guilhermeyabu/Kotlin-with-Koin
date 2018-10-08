package inatel.br.kotlinexample.network

import inatel.br.kotlinexample.model.Pokemon
import io.reactivex.Observable
import retrofit2.http.GET

interface PokemonService{

  @GET("pokemon")
  fun list(): Observable<List<Pokemon>>
}