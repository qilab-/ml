package jp.qilab.aiis.fractal

import javafx.application.Application
import javafx.scene.canvas.GraphicsContext

object Tree {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[TreeApp], args: _*)
  }

  class TreeApp extends CurveApp {
    override def draw(): Unit = {
      val c = new Tree(g)
      c.move(300, 600)
      c.draw(7, 450, math.Pi * -0.5, 1)
    }
  }
}

class Tree(g: GraphicsContext) extends Curve(g) {
  def draw(n: Int, len: Double, angle: Double, sw: Int): Unit = {
    // save current position
    val (x, y) = (lastX, lastY)

    if (n == 1) {
      forward(len, angle)
    } else {
      val l = len / math.sqrt(2.0)
      val a = math.Pi * 0.15 * sw
      forward(l * 0.33, angle)
      draw(n - 1, l * 0.8, angle - a, 1)
      forward(l * 0.33, angle)
      draw(n - 1, l * 0.7, angle + a * 1.5, -1)
      forward(l * 0.33, angle)
      draw(n - 1, l * 0.6, angle, 1)
    }

    // restore
    lastX = x
    lastY = y
  }
}
