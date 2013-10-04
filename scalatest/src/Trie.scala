/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 14:18
 */
class Trie {
  private var _trie : Impl = new Impl()
  private val _cont : Cont = new Cont(_trie.root())

  def copyof(trie : Trie) = {
    _trie = trie._trie
    _cont.copyof(trie._cont)
  }

  def insert(i : Int, symbol : Byte) : Int = {
    val node = _trie.insert(_cont.nodeof(i), symbol)
    if (node.id() == _cont.size()) {
      _cont.push(node)
    }
    return node.id()
  }

  def symbolof(i : Int) : Int = {
    return _cont.nodeof(i).symbol()
  }

  def setdataof(i : Int, data : Any) = {
    _cont.setdata(i, data)
  }

  def dataof(i : Int) : Any = {
    return _cont.dataof(i)
  }

  def parentof(i : Int) : Int = {
    val node = _cont.nodeof(i).parent()
    if (node != null) {
      return node.id()
    }
    return -1
  }

  def nextof(i : Int, symbol : Byte) : Int = {
    return _cont.nodeof(i).get(symbol).id()
  }

  def keysof(i : Int) : Iterable[Byte] = {
    return _cont.nodeof(i).keys()
  }

  def isfork(i : Int) : Boolean = {
    return _cont.nodeof(i).size() > 1
  }

  def isleaf(i : Int) : Boolean = {
    return _cont.nodeof(i).size() == 0
  }

  def size() : Int = {
    return _trie.size()
  }
}
