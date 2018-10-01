package inatel.br.kotlinexample.util

import android.util.Log

object Logger {
  
  val DEBUG : Boolean = true
  private val CLASS_STACK_ITEM = 3
  private val MAX_TAG_LENGTH = 23
  
  fun getTag() : String {
    val caller : StackTraceElement = Thread.currentThread().stackTrace[CLASS_STACK_ITEM]
    var tag = caller.className
    val lastDot = tag.lastIndexOf('.')
    
    if (lastDot > 0){
      tag = tag.substring(lastDot + 1)
    }
    
    if (tag.length > MAX_TAG_LENGTH) {
      tag = tag.substring(0, MAX_TAG_LENGTH)
    }
    
    return tag
  }
  
  private fun getTag(caller : Class<Any>) : String {
    var tag  = caller.simpleName
    
    if (tag.length > MAX_TAG_LENGTH) {
      tag = tag.substring(0, MAX_TAG_LENGTH)
    }
    
    return tag
  }
  
  fun d(caller: Class<Any>, text: String){
    Log.d(getTag(caller), text)
  }
  
  fun e(caller: Class<Any>, text: String){
    Log.e(getTag(caller), text)
  }
  
  fun i(caller: Class<Any>, text: String){
    Log.i(getTag(caller), text)
  }
  
}