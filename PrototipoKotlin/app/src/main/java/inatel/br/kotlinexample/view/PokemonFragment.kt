package inatel.br.kotlinexample.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import inatel.br.kotlinexample.R
import inatel.br.kotlinexample.databinding.FragmentPokemonBinding
import org.koin.android.ext.android.get

class PokemonFragment : Fragment() {
  
  private lateinit var mBinding: FragmentPokemonBinding
  
  private lateinit var mViewModel: PokemonViewModel
  
  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    
    mBinding = DataBindingUtil.inflate(layoutInflater, R.layout
        .fragment_pokemon, container, false)
    
    mViewModel = get()
    
    return mBinding.root
  }
  
  override fun onResume() {
    super.onResume()
    mViewModel.onResume()
  }
  
}