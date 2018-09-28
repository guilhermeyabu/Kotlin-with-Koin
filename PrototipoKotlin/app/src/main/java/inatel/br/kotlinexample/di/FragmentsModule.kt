package inatel.br.kotlinexample.di

import inatel.br.kotlinexample.view.PokemonFragment
import org.koin.dsl.module.module

val fragmentModule = module {
  single { PokemonFragment() }
}

val fragmentProvider = listOf(fragmentModule)