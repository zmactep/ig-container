package igcont.trie

import collection.JavaConverters._
import java.util

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 12:50
 */
class Cont {
  private var _cont : util.Vector[ContData] = new util.Vector[ContData]()

  def this(initnode : Node) = {
    this()
    _cont.addElement(new ContData(initnode))
  }

  def copyOf(cont : Cont) = {
    _cont = new util.Vector[ContData]()
    for(i <- cont._cont.asScala) {
      _cont.addElement(new ContData(i.node()))
    }
  }

  def push(node : Node) = _cont.addElement(new ContData(node))

  def nodeOf(i : Int) : Node = _cont.elementAt(i).node()

  def dataOf(i : Int) : Any = _cont.elementAt(i).data

  def setDataOf(i : Int, data : Any) = _cont.elementAt(i).data = data

  def size() : Int = _cont.size()
}
