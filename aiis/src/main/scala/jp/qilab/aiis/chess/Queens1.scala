package jp.qilab.aiis.chess

object Queens1 {
  def main(args: Array[String]): Unit = {
    new Queens1(4).start()
  }
}

class Queens1(n: Int) extends Queens(n) {
  type Patterns = List[List[(Int, Int)]]
  var level = 0
  val indicator = "- "

  def trace(fname: String, arg: Any*)(body: => Patterns): Patterns = {
    val args = arg.mkString(",")
    println(s"${indicator * level}${level}: ${fname} (${args})")

    level += 1
    val patterns = body
    level -= 1
    println(s"${indicator * level}${level}: ${fname} = List(")
    patterns.foreach { pattern =>
      println(indicator * (level + 1) + pattern.toString)
    }
    println(indicator * level + ")")
    patterns
  }

  override def queen(row: Int): List[List[(Int, Int)]] = {
    trace("queen", row) {
      super.queen(row)
    }
  }
}
