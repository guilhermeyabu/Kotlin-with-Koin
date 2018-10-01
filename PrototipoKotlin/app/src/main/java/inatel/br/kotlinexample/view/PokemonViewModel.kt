package inatel.br.kotlinexample.view

import android.content.Context
import android.util.Log
import android.widget.Toast
import inatel.br.kotlinexample.util.Logger

class PokemonViewModel(private val mContext: Context) {
  
  private val TAG = Logger.getTag()
  
  fun onResume() {
    if (Logger.DEBUG) {
      Log.d(TAG, "View Model")
    }
    
    Toast.makeText(mContext, "Estou no View Model", Toast.LENGTH_LONG).show()
  }
}