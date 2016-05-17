package jp.qilab.aiis.fractal

import javafx.scene.canvas.GraphicsContext

class Curve(val g: GraphicsContext) {
  var lastX = 0.0
  var lastY = 0.0

  def move(x: Double, y: Double): Unit = {
    lastX = x
    lastY = y
  }

  def forward(len: Double, angle: Double): Unit = {
    val x = lastX + len * math.cos(angle)
    val y = lastY + len * math.sin(angle)
    g.strokeLine(lastX, lastY, x, y)
    move(x, y)
  }

  def draw(len: Double, angle: Double): Unit = {
    forward(len, angle)
  }
}
