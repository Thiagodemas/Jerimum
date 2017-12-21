package jerimum

import java.awt.{ Graphics2D, RenderingHints }

import scala.collection.SortedMap


object Drawing {
  private[this] val empty = SortedMap[Int, List[Graphics2D => Unit]]()
  private[this] var layers = empty
  private[this] def all = layers.values.flatten

  private[this] val rh = new RenderingHints(
    RenderingHints.KEY_TEXT_ANTIALIASING,
    RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB)

  def draw(g: Graphics2D): Unit = {
    g match {
      case g: Graphics2D =>
        g.setRenderingHints(rh)
    }
    all.foreach(f => f(g))
    layers = empty
  }

  def include(z: Int, function: Graphics2D => Unit) = {
    layers += z -> (function :: layers.getOrElse(z, Nil))
  }
}