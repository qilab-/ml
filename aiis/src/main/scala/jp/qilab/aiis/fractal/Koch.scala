package jp.qilab.aiis.fractal

import javafx.application.Application
import javafx.scene.canvas.GraphicsContext

object Koch {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[KochApp], args: _*)
  }

  class KochApp extends CurveApp {
    override def draw(): Unit = {
      val c = new Koch(g)
      c.move(50, 300)
      c.draw(5, 500, 0)
    }
  }
}

class Koch(g: GraphicsContext) extends Curve(g) {
  val theta = math.Pi * 0.25

  def draw(n: Int, len: Double, angle: Double): Unit = {
    if (n == 1) {
      forward(len, angle)
    } else {
      val l = len / (2 * math.cos(theta) + 2)
      val a = theta
      draw(n - 1, l, angle)
      draw(n - 1, l, angle - a)
      draw(n - 1, l, angle + a)
      draw(n - 1, l, angle)
    }
  }
}
