package igcont.trie

import java.util

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 11:47
 */
class Node(p: Node, s: Char, i: Int) {
  private val _parent   : Node            = p
  private val _symbol   : Char            = s
  private val _id       : Int             = i
  private val _children : util.TreeMap[Char, Node] = new util.TreeMap[Char, Node]()

  def this() = this(null, 0, 0)

  def parent() : Node = _parent

  def symbol() : Char = _symbol

  def id() : Int = _id

  def keys() : util.Set[Char] = _children.keySet()

  def length() : Int = _children.keySet().size()

  def get(s : Char) : Node = _children.get(s)

  def set(n : Node) = _children.put(n.symbol(), n)

  def contains(s : Byte) : Boolean = _children.containsKey(s)

  def size() : Int = _children.size()
}
