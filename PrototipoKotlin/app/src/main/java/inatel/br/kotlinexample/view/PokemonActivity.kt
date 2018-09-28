package inatel.br.kotlinexample.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import inatel.br.kotlinexample.R
import inatel.br.kotlinexample.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityPokemonBinding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon)
  }
}
