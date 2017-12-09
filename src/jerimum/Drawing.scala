package jerimum

import java.awt.{ Graphics2D, RenderingHints }

import scala.collection.SortedMap


object Draw {
  private[this] val vazia = SortedMap[Int, List[Graphics2D => Unit]]()
  private[this] var camadas = vazia
  private[this] def todos = camadas.values.flatten

  private[this] val rh = new RenderingHints(
    RenderingHints.KEY_TEXT_ANTIALIASING,
    RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB)

  def draw(g: Graphics2D): Unit = {
    g match {
      case g: Graphics2D =>
        g.setRenderingHints(rh)
    }
    todos.foreach(f => f(g))
    camadas = vazia
  }

  def incluir(z: Int, funcao: Graphics2D => Unit) = {
    camadas += z -> (funcao :: camadas.getOrElse(z, Nil))
  }
}