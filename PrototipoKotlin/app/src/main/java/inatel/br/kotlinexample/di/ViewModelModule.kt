package inatel.br.kotlinexample.di

import inatel.br.kotlinexample.view.PokemonViewModel
import org.koin.dsl.module.module

val viewModelModule = module {
  single { PokemonViewModel() }
}

val viewModelProvider = listOf(viewModelModule)