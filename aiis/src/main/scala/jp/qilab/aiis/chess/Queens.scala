package jp.qilab.aiis.chess

object Queens {
  def main(args: Array[String]): Unit = {
    new Queens(8).start()
  }
}

class Queens(val n: Int) {
  def check(row: Int, column: Int, pattern: List[(Int, Int)]): Boolean = {
    pattern.forall { case (r, c) =>
      column != c && row - r != math.abs(column - c)
    }
  }

  def queen(row: Int): List[List[(Int, Int)]] = {
    if (row == 0) {
      List(Nil)
    } else {
      for {
        pattern <- queen(row - 1)
        column <- 1 to n if check(row, column, pattern)
      } yield {
        (row, column) :: pattern
      }
    }
  }

  def start(): Unit = {
    val result = queen(n).map { pattern =>
      pattern.map { case (row, column) =>
        "+" * (column - 1) + "Q" + "+" * (n - column)
      }.mkString("\n")
    }.mkString("\n\n")
    println(result)
  }
}
