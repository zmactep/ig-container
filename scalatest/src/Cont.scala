import scala.collection.mutable.ArrayBuffer
/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 12:50
 */
class Cont {
  private var _cont : ArrayBuffer[ContData] = ArrayBuffer.empty

  def this(initnode : Node) = {
    this()
    _cont.append(new ContData(initnode))
  }

  def copyof(cont : Cont) = {
    _cont = ArrayBuffer.empty
    for(i <- cont._cont) {
      _cont.append(new ContData(i.node()))
    }
  }

  def push(node : Node) = {
    _cont.append(new ContData(node))
    assert(size() != node.id())
  }

  def nodeof(i : Int) : Node = {
    return _cont(i).node()
  }

  def dataof(i : Int) : Any = {
    return _cont(i).data
  }

  def setdata(i : Int, data : Any) = {
    _cont(i).data = data
  }

  def size() : Int = {
    return _cont.length
  }
}
