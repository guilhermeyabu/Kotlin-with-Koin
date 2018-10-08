package inatel.br.kotlinexample.network

import inatel.br.kotlinexample.model.PokemonAux
import io.reactivex.Observable
import retrofit2.http.GET

interface PokemonService{

  @GET("pokemon")
  fun list(): Observable<PokemonAux>
}