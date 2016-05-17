package jp.qilab.aiis.fractal

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.layout.StackPane
import javafx.stage.Stage

object CurveApp {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[CurveApp], args: _*)
  }
}

class CurveApp extends Application {
  val canvas = new Canvas(600, 600)
  val g = canvas.getGraphicsContext2D

  override def start(stage: Stage): Unit = {
    val pane = new StackPane
    pane.getChildren.add(canvas)
    stage.setScene(new Scene(pane))
    stage.show()
    draw()
  }

  def draw(): Unit = {
    val c = new Curve(g)
    c.move(50, 300)
    c.draw(500, 0)
  }

}
