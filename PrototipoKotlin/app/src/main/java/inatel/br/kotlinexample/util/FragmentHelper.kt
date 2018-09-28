package inatel.br.kotlinexample.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

object FragmentHelper {
  
  fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int, tag: String?) {
    if (! fragment.isAdded) {
      val transaction = fragmentManager.beginTransaction()
      transaction.add(frameId, fragment)
      if (tag != null) {
        transaction.addToBackStack(tag)
      }
      transaction.commit()
    } else {
      println("addFragment error: Fragment already added!")
    }
  }
  
  fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, frameId: Int, tag: String) {
    if (! fragment.isAdded) {
      val transaction = fragmentManager.beginTransaction()
      transaction.replace(frameId, fragment)
      transaction.addToBackStack(tag)
      transaction.commit()
    } else {
      println("addFragment error: Fragment already added!")
    }
  }
}