package igcont.kmer

import collection.JavaConverters._
import scala.collection.immutable.TreeMap
import java.util

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 08.10.13
 * Time: 19:48
 */
class Hasher(k : Int, alpha : TreeMap[Char, Int]) {
  private val _ksize = k
  private val _alpha = alpha
  private val _asize = alpha.size
  private val _buffer = new util.Vector[Int]()
  private val _sbuffer = new util.Vector[Char]()

  def add(c : Char) = {
    _sbuffer.addElement(c)
    if (_sbuffer.size() >= _ksize) {
      if (_buffer.size() == 0) {
        _buffer.addElement(_sbuffer.asScala.zipWithIndex.foldRight(0)((cc, prev) =>
          prev + _alpha.get(cc._1).get * math.pow(_asize, cc._2).toInt))
      } else {
        val elem = _alpha.get(_sbuffer.get(_sbuffer.size() - _ksize - 1)).get
        val last = _buffer.lastElement()
        val prenew  = (last - elem) / _asize
        _buffer.addElement(prenew + _alpha.get(c).get * math.pow(_asize, _ksize - 1).toInt)
      }
    }
  }

  def get() : Iterable[Int] = _buffer.asScala
}
