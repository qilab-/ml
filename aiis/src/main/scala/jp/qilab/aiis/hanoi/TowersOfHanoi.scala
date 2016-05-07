package jp.qilab.aiis.hanoi

class TowersOfHanoi(val n: Int) {
  val Space = "\u002d"
  val Hyphen = "\u2012"
  val Square = "\u2580"

  def hanoi(m: Int, from: Int, to: Int, work: Int, s: Array[List[Int]]): Unit = {
    if (m == 1) {
      s(to) = s(from).head :: s(to)
      s(from) = s(from).tail
      println(disp(s.toList.map(_.reverse)))
    } else {
      hanoi(m - 1, from, work, to, s)
      hanoi(1, from, to, work, s)
      hanoi(m - 1, work, to, from, s)
    }
  }

  def disp(a: List[List[Int]]): String = {
    if (a == List(Nil, Nil, Nil)) {
      Hyphen * ((n * 2 + 2) * 3 + 2) + "\n"
    } else {
      disp(a.map(l => if (l == Nil) Nil else l.tail)) + "\n" +
      a.map {
        case Nil => 0
        case h :: t => h
      }.map { i =>
        Space * (n - i + 1) + Square * 2 * i + Space * (n - i + 1)
      }.mkString("|")
    }
  }

  def start(): Unit = {
    val s = Array((1 to n).toList, Nil, Nil)  // initial state
    hanoi(n, 0, 2, 1, s)
  }
}

object TowersOfHanoi extends App {
  new TowersOfHanoi(4).start
}
