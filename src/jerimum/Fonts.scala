package jerimum


import java.awt.Font

object Fonte {

}

case class Fonte(tamanho: Int) {
  private[this] val font = new Font("Dialog", Font.BOLD, tamanho);

  def desenhe_centralizado(msg: String, x: Double, y: Double, z: Int, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      g.setFont(font)
      val largura = g.getFontMetrics.stringWidth(msg)
      val altura = g.getFontMetrics.getHeight
      g.drawString(msg, x.toInt - largura / 2, y.toInt - altura / 2)
    })

  }

  def desenhe(msg: String, x: Double, y: Double, z: Int, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      g.setFont(font)
      g.drawString(msg, x.toInt, y.toInt)
    })
  }
}