import scala.collection.mutable.HashMap

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 11:47
 */
class Node(p: Node, s: Byte, i: Int) {
  private val _parent   : Node            = p
  private val _symbol   : Byte            = s
  private val _id       : Int             = i
  private val _children : HashMap[Byte, Node] = new HashMap[Byte, Node]()

  def this() = this(null, 0, 0)

  def parent() : Node = {
    return _parent
  }

  def symbol() : Byte = {
    return _symbol
  }

  def id() : Int = {
    return _id
  }

  def keys() : Iterable[Byte] = {
    return _children.keys
  }

  def length() : Int = {
    return _children.keys.size
  }

  def get(s : Byte) : Node = {
    return _children(s)
  }

  def set(n : Node) = {
    _children.put(n.symbol(), n)
  }

  def contains(s : Byte) : Boolean = {
    return _children contains s
  }

  def size() : Int = {
    return _children.size
  }
}
