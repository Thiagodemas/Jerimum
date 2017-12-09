package jerimum

import java.awt.event.{ MouseEvent, MouseListener, MouseMotionListener }



object Mouse extends MouseListener with MouseMotionListener {
  private[this] val buttons = new Array[Boolean](4)
  private[this] var _x, _y: Int = 0
  def LEFT_BUTTON: Boolean = buttons(1)
  def RIGHT_BUTTON: Boolean = buttons(3)

  private[this] def update(e: MouseEvent, value: Boolean) = {
    val button = e.getButton()
    if (button == MouseEvent.BUTTON1)
      buttons(1) = value
    if (button == MouseEvent.BUTTON3)
      buttons(3) = value
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