package jerimum

import java.awt.{ Canvas, Dimension }


import javax.swing.JFrame

class Screen(var title: String, var width: Int, var height: Int) {
  private[this] val dim = new Dimension(width, height)
  val canvas = new Canvas() {
    setPreferredSize(dim)
    setMaximumSize(dim)
    setMinimumSize(dim)
    setFocusable(false)
  }
  val frame = new JFrame(title) {
    setIconImage(Image("potigol.png").buffer)
    setSize(dim)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setResizable(false)
    setLocationRelativeTo(null)
    setVisible(true)
    add(canvas)
    pack()
  }
}