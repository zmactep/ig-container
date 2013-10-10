import igcont.trie.Trie
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

    val start = System.currentTimeMillis()
    for (i <- 1 to 100000) {
      var key = 0
      for (j <- 1 to 100) {
        key = t.insert(key, rand.nextInt(4).toChar)
        t.setDataOf(key, rand.nextInt(100))
      }
    }

    println((System.currentTimeMillis() - start) / 1000.0)

    val m = (rc.totalMemory() - rc.freeMemory()) / 1024 / 1024
    println(m)

    println(t.size())
  }
}