package jerimum


import java.awt.Font

object Fonts {

}

case class Fonts(size: Int) {
  private[this] val font = new Font("Dialog", Font.BOLD, size);

  def draw_centered(msg: String, x: Double, y: Double, z: Int, c: ColorF) = {
    Drawing.include(z, g => {
      g.setColor(c.color)
      g.setFont(font)
      val width = g.getFontMetrics.stringWidth(msg)
      val height = g.getFontMetrics.getHeight
      g.drawString(msg, x.toInt - width / 2, y.toInt - height / 2)
    })

  }

  def draw(msg: String, x: Double, y: Double, z: Int, c: ColorF) = {
    Drawing.include(z, g => {
      g.setColor(c.color)
      g.setFont(font)
      g.drawString(msg, x.toInt, y.toInt)
    })
  }
}