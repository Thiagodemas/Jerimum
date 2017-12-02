package jerimum

import java.awt.event.{ MouseEvent, MouseListener, MouseMotionListener }



object Mouse extends MouseListener with MouseMotionListener {
  private[this] val botoes = new Array[Boolean](4)
  private[this] var _x, _y: Int = 0
  def BOTAO_ESQUERDO: Boolean = botoes(1)
  def BOTAO_DIREITO: Boolean = botoes(3)

  private[this] def update(e: MouseEvent, valor: Boolean) = {
    val botao = e.getButton()
    if (botao == MouseEvent.BUTTON1)
      botoes(1) = valor
    if (botao == MouseEvent.BUTTON3)
      botoes(3) = valor
  }

  override def mousePressed(e: MouseEvent) = this(e) = true
  override def mouseReleased(e: MouseEvent) = this(e) = false

  override def mouseMoved(e: MouseEvent) = {
    _x = e.getX()
    _y = e.getY()
  }

  def x: Int = _x
  def y: Int = _y

  override def mouseDragged(e: MouseEvent) = {}
  override def mouseClicked(e: MouseEvent) = {}
  override def mouseEntered(e: MouseEvent) = {}
  override def mouseExited(e: MouseEvent) = {}
}