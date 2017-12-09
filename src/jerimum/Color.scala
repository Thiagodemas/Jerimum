package jerimum

import java.awt.Color


case class ColorF(var red: Int, var green: Int, var blue:Int) {
  def color = new Color(red, green, blue)
  def this(color: Color) = this(color.getRed, color.getGreen, color.getBlue)
}

object ColorF {
  val YELLOW = new ColorF(Color.yellow)
  val BLUE = new ColorF(Color.blue)
  val WHITE = new ColorF(Color.white)
  val CYAN = new ColorF(Color.cyan)
  val GRAY = new ColorF(Color.gray)
  val LIGHT_GRAY= new ColorF(Color.lightGray)
  val DARK_GRAY = new ColorF(Color.darkGray)
  val ORANGE = new ColorF(Color.orange)
  val MAGENTA = new ColorF(Color.magenta)
  val BLACK = new ColorF(Color.black)
  val PINK = new ColorF(Color.pink)
  val GREEN = new ColorF(Color.green)
  val RED = new ColorF(Color.red)
}
