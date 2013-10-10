package igcont.trie

import collection.JavaConverters._
import java.util
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 14:18
 */
class Trie {
  private var _trie  : Impl             = new Impl()
  private val _cont  : Cont             = new Cont(_trie.root())
  private var _cache : util.Vector[Int] = new util.Vector[Int]()

  def copyOf(trie : Trie) = {
    _trie = trie._trie
    _cont.copyOf(trie._cont)
    _cache = trie._cache
  }

  def insert(i : Int, symbol : Char) : Int = {
    val node = _trie.insert(_cont.nodeOf(i), symbol)
    if (node.id() == _cont.size()) {
      _cont.push(node)
    }
    node.id()
  }

  def symbolOf(i : Int) : Int = _cont.nodeOf(i).symbol()

  def setDataOf(i : Int, data : Any) = _cont.setDataOf(i, data)

  def dataOf(i : Int) : Any = _cont.dataOf(i)

  def parentOf(i : Int) : Int = {
    val node = _cont.nodeOf(i).parent()
    if (node != null) node.id() else -1
  }

  def nextOf(i : Int, symbol : Char) : Int = _cont.nodeOf(i).get(symbol).id()

  def keysOf(i : Int) : util.Set[Char] = _cont.nodeOf(i).keys()

  def isFork(i : Int) : Boolean = _cont.nodeOf(i).size() > 1

  def isLeaf(i : Int) : Boolean = _cont.nodeOf(i).size() == 0

  def size() : Int = _trie.size()

  def cache() : mutable.Buffer[Int] = {
    def dfs(current: Int, last : Int) : Int = {
      _cache.setElementAt(current, last)
      var newlast : Int = current
      for (i <- _cont.nodeOf(current).keys().asScala) {
        newlast = dfs(_cont.nodeOf(current).get(i).id(), newlast)
      }
      newlast
    }

    if (_cache.size() != size()) {
      _cache = new util.Vector[Int](size())
      _cache.setSize(size())
      dfs(0, 0)
    }

    _cache.asScala
  }
}
