package igcont.kmer


import java.util
import collection.JavaConverters._
import scala.collection.immutable.TreeMap

/**
 * Created with IntelliJ IDEA.
 * User: mactep
 * Date: 07.10.13
 * Time: 17:03
 */
class Counter(a : String, s : Char, ksize : Int) {
  private val _kmers   : util.HashMap[Int, util.LinkedList[Int]] = new util.HashMap[Int, util.LinkedList[Int]]()
  private val _alpha   : TreeMap[Char, Int] = TreeMap[Char, Int](a.zipWithIndex.toSeq:_*)
  private val _special : Char               = s
  private val _ksize   : Int                = ksize

  def add(seq : String, i : Iterable[Int]) = {
    val kmers = hashs(seq)
    for((k, n) <- kmers zip i) {
      if (!_kmers.containsKey(k)) {
        _kmers.put(k, new util.LinkedList[Int]())
      }
      _kmers.get(k).add(n)
    }
  }

  def check(kmer : String, use_special : Boolean) : Boolean =
    kmer.forall(c => _alpha.contains(c) || (use_special && c == _special))

  def hashs(seq : String) : Iterable[Int] = {
    val a = new Hasher(_ksize, _alpha)
    seq.foreach(c => a.add(c))
    a.get()
  }

  def hash(kseq : String) : Int =
    if (check(kseq, use_special = false)) hashs(kseq).head else -1

  def get(kmer : String) : Option[Iterable[Int]] = {
    if (check(kmer, use_special = true)) {
      val specs = kmer.count(_special => true)
      if (specs == 1) {
        val result = new util.LinkedList[Int]()
        _alpha.foreach(c => result.addAll(_kmers.get(hash(kmer.replace(_special, c._1)))))
        Some(result.asScala)
      } else if (specs == 0) {
        Some(_kmers.get(hash(kmer)).asScala)
      } else {
        println("!")
        None
      }
    } else {
      println("!!")
      None
    }
  }

  def k() : Int = {
    _ksize
  }
}
