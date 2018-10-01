package inatel.br.kotlinexample.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import inatel.br.kotlinexample.R
import inatel.br.kotlinexample.databinding.ActivityPokemonBinding
import inatel.br.kotlinexample.util.FragmentHelper
import org.koin.android.ext.android.inject

class PokemonActivity : AppCompatActivity() {
  
  private val mPokemonFragment : PokemonFragment by inject()
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding : ActivityPokemonBinding = DataBindingUtil.
        setContentView(this, R.layout.activity_pokemon)
    
    attachPokemonFragment()
  }
  
  private fun attachPokemonFragment() {
    FragmentHelper.addFragment(supportFragmentManager, mPokemonFragment, R.id
        .contentFrame, null)
  }
}
