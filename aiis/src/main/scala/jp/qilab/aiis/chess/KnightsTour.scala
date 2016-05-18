package jp.qilab.aiis.chess

object KnightsTour {
  def main(args: Array[String]): Unit = {
    new KnightsTour(5).start(0, 0)
  }
}

class KnightsTour(val n: Int) {
  // n * n chess board
  val board: Array[Array[Int]] = Array.fill(n, n)(0)
  // movable pattern
  val pattern =
    for {
      a <- List((1, 2), (2, 1))
      b <- List(1, -1)
      c <- List(1, -1)
    } yield (a._1 * b, a._2 * c)

  def knight(row: Int, column: Int, cnt: Int, route: List[(Int, Int)]): List[(Int, Int)] = {
    if (row >= 0 && row < n && column >= 0 && column < n && board(row)(column) == 0) {
      board(row)(column) = cnt
      if (cnt == n * n)
        return (row, column) :: route
      for (p <- pattern) {
        val rt = knight(row + p._1, column + p._2, cnt + 1, (row, column) :: route)
        if (rt != Nil)
          return rt
      }
      board(row)(column) = 0
    }
    Nil
  }

  def start(row: Int, column: Int): Unit = {
    println(knight(row, column, 1, Nil))
    val result = board.map(_.map("%02d ".format(_)).mkString).mkString("\n")
    println(result)
  }
}
