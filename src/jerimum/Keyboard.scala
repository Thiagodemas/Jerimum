package jerimum

import java.awt.event.{ KeyEvent, KeyListener }


object Keyboard extends KeyListener with LettersKeyboard {
  protected[this] val keyboardKey = new Array[Boolean](256)

  private[this] def update(e: KeyEvent, value: Boolean) = {
    val cod = e.getKeyCode()
    if (cod >= 0 && cod < keyboardKey.length)
      keyboardKey(cod) = value
  }

  override def keyPressed(e: KeyEvent) = this(e) = true

  override def keyReleased(e: KeyEvent) = this(e) = false

  override def keyTyped(e: KeyEvent) = {}
}

trait LettersKeyboard {
  protected[this] val keyboardKey: Array[Boolean]
  import java.awt.event.KeyEvent._
  def KEY_A: Boolean = keyboardKey(VK_A)
  def KEY_B: Boolean = keyboardKey(VK_B)
  def KEY_C: Boolean = keyboardKey(VK_C)
  def KEY_D: Boolean = keyboardKey(VK_D)
  def KEY_E: Boolean = keyboardKey(VK_E)
  def KEY_F: Boolean = keyboardKey(VK_F)
  def KEY_G: Boolean = keyboardKey(VK_G)
  def KEY_H: Boolean = keyboardKey(VK_H)
  def KEY_I: Boolean = keyboardKey(VK_I)
  def KEY_J: Boolean = keyboardKey(VK_J)
  def KEY_K: Boolean = keyboardKey(VK_K)
  def KEY_L: Boolean = keyboardKey(VK_L)
  def KEY_M: Boolean = keyboardKey(VK_M)
  def KEY_N: Boolean = keyboardKey(VK_N)
  def KEY_O: Boolean = keyboardKey(VK_O)
  def KEY_P: Boolean = keyboardKey(VK_P)
  def KEY_Q: Boolean = keyboardKey(VK_Q)
  def KEY_R: Boolean = keyboardKey(VK_R)
  def KEY_S: Boolean = keyboardKey(VK_S)
  def KEY_T: Boolean = keyboardKey(VK_T)
  def KEY_U: Boolean = keyboardKey(VK_U)
  def KEY_V: Boolean = keyboardKey(VK_V)
  def KEY_W: Boolean = keyboardKey(VK_W)
  def KEY_X: Boolean = keyboardKey(VK_X)
  def KEY_Y: Boolean = keyboardKey(VK_Y)
  def KEY_Z: Boolean = keyboardKey(VK_Z)
  def KEY_0: Boolean = keyboardKey(VK_0)
  def KEY_1: Boolean = keyboardKey(VK_1)
  def KEY_2: Boolean = keyboardKey(VK_2)
  def KEY_3: Boolean = keyboardKey(VK_3)
  def KEY_4: Boolean = keyboardKey(VK_4)
  def KEY_5: Boolean = keyboardKey(VK_5)
  def KEY_6: Boolean = keyboardKey(VK_6)
  def KEY_7: Boolean = keyboardKey(VK_7)
  def KEY_8: Boolean = keyboardKey(VK_8)
  def KEY_9: Boolean = keyboardKey(VK_9)
  def SPACE_BUTTON: Boolean = keyboardKey(VK_SPACE)
  def SPACE: Boolean = SPACE_BUTTON
  def ENTER: Boolean = keyboardKey(VK_ENTER)
  def UP: Boolean = keyboardKey(VK_UP)
  def DOWN: Boolean = keyboardKey(VK_DOWN)
  def LEFT: Boolean = keyboardKey(VK_LEFT)
  def RIGHT: Boolean = keyboardKey(VK_RIGHT)
}