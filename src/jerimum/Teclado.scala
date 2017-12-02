package jerimum

import java.awt.event.{ KeyEvent, KeyListener }


object Teclado extends KeyListener with TecladoLetras {
  protected[this] val teclas = new Array[Boolean](256)

  private[this] def update(e: KeyEvent, valor: Boolean) = {
    val cod = e.getKeyCode()
    if (cod >= 0 && cod < teclas.length)
      teclas(cod) = valor
  }

  override def keyPressed(e: KeyEvent) = this(e) = true

  override def keyReleased(e: KeyEvent) = this(e) = false

  override def keyTyped(e: KeyEvent) = {}
}

trait TecladoLetras {
  protected[this] val teclas: Array[Boolean]
  import java.awt.event.KeyEvent._
  def TECLA_A: Boolean = teclas(VK_A)
  def TECLA_B: Boolean = teclas(VK_B)
  def TECLA_C: Boolean = teclas(VK_C)
  def TECLA_D: Boolean = teclas(VK_D)
  def TECLA_E: Boolean = teclas(VK_E)
  def TECLA_F: Boolean = teclas(VK_F)
  def TECLA_G: Boolean = teclas(VK_G)
  def TECLA_H: Boolean = teclas(VK_H)
  def TECLA_I: Boolean = teclas(VK_I)
  def TECLA_J: Boolean = teclas(VK_J)
  def TECLA_K: Boolean = teclas(VK_K)
  def TECLA_L: Boolean = teclas(VK_L)
  def TECLA_M: Boolean = teclas(VK_M)
  def TECLA_N: Boolean = teclas(VK_N)
  def TECLA_O: Boolean = teclas(VK_O)
  def TECLA_P: Boolean = teclas(VK_P)
  def TECLA_Q: Boolean = teclas(VK_Q)
  def TECLA_R: Boolean = teclas(VK_R)
  def TECLA_S: Boolean = teclas(VK_S)
  def TECLA_T: Boolean = teclas(VK_T)
  def TECLA_U: Boolean = teclas(VK_U)
  def TECLA_V: Boolean = teclas(VK_V)
  def TECLA_W: Boolean = teclas(VK_W)
  def TECLA_X: Boolean = teclas(VK_X)
  def TECLA_Y: Boolean = teclas(VK_Y)
  def TECLA_Z: Boolean = teclas(VK_Z)
  def TECLA_0: Boolean = teclas(VK_0)
  def TECLA_1: Boolean = teclas(VK_1)
  def TECLA_2: Boolean = teclas(VK_2)
  def TECLA_3: Boolean = teclas(VK_3)
  def TECLA_4: Boolean = teclas(VK_4)
  def TECLA_5: Boolean = teclas(VK_5)
  def TECLA_6: Boolean = teclas(VK_6)
  def TECLA_7: Boolean = teclas(VK_7)
  def TECLA_8: Boolean = teclas(VK_8)
  def TECLA_9: Boolean = teclas(VK_9)
  def TECLA_ESPACO: Boolean = teclas(VK_SPACE)
  def TECLA_ESPAÇO: Boolean = TECLA_ESPACO
  def TECLA_ENTER: Boolean = teclas(VK_ENTER)
  def TECLA_PARA_CIMA: Boolean = teclas(VK_UP)
  def TECLA_PARA_BAIXO: Boolean = teclas(VK_DOWN)
  def TECLA_PARA_ESQUERDA: Boolean = teclas(VK_LEFT)
  def TECLA_PARA_DIREITA: Boolean = teclas(VK_RIGHT)
}