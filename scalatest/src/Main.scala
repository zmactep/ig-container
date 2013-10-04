import scala.util.Random

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 04.10.13
 * Time: 13:10
 */

object Main{
  def main(args : Array[String]) = {
    val t = new Trie()
    val rand = new Random()
    val rc = Runtime.getRuntime

    for(i <- 1 to 50000) {
      var key = 0
      for(j <- 1 to 100) {
        key = t.insert(key, rand.nextInt(4).toByte)
      }
    }

    val m = (rc.totalMemory() - rc.freeMemory()) / 1024 / 1024
    println(m)
    println(t.size())
  }
}