package jerimum

import java.awt.Graphics2D

import scala.util.{ Failure, Try }


object Game extends Runnable {
  var title: String = "Unnamed"
  var width: Int = 640
  var height: Int = 480
  var fps: Int = 60
  private[this] var display: Screen = _
  private[this] var running = false
  private[this] var thread: Thread = _

  private[this] var dwg, update = () => {}

  private[this] def init() = {
    display = new Screen(title, width, height) {
      frame.addKeyListener(Keyboard)
      frame.addMouseListener(Mouse)
      frame.addMouseMotionListener(Mouse)
      canvas.addMouseListener(Mouse)
      canvas.addMouseMotionListener(Mouse)
    }
  }

  private[this] def drawing() = {
    Option(display.canvas.getBufferStrategy) match {
      case None =>
        display.canvas.createBufferStrategy(3)
      case Some(strategy) => strategy.getDrawGraphics match {
        case g: Graphics2D =>
          g.clearRect(0, 0, width, height)
          Drawing.draw(g)
          strategy.show
          g.dispose()
      }
    }
  }

  override def run() = {
    init()
    val frequency = 1000000000.0 / fps
    var delta = 0.0
    var last = System.nanoTime()
    var time = 0L
    var cycles = 0
    while (running) {
      val now = System.nanoTime()
      delta += (now - last) / frequency
      time += now - last
      last = now
      if (delta >= 1) {
        update()
        dwg()
        drawing()
        cycles += 1
        delta -= 1
      }
      if (time >= 1000000000) {
        cycles = 0
        time = 0
      }
    }
    stop()
  }

  def start(title: String = "Potigol with Jerimum", width: Int = 640,
              height: Int = 480, update: => Unit = {},
              draw: => Unit = {}, fps: Int = 60) = synchronized {
    this.title = title
    this.width = width  
    this.height = height
    this.fps = fps
    this.update = update _
    this.dwg = draw _
    if (!running) {
      running = true
      thread = new Thread(this) {
        start()
      }
    }
  }

  private[this] def stop() = synchronized {
    if (running) {
      running = false
      Try(thread.join()) match {
        case Failure(e) => e.printStackTrace()
        case _          =>
      }
    }
  }

  def distance(x1: Double, y1: Double, x2: Double, y2: Double) = {
    Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
  }
  val distanc = distance _

  def projection_X(angle: Double, value: Double) = {
    Math.sin(angle * Math.PI / 180) * value

  }

  def projection_Y(angle: Double, value: Double) = {
    -Math.cos(angle * Math.PI / 180) * value
  }

  val Projection_X = projection_X _
  val projectionX = projection_X _
  val PROJECTION_X = projection_X _
  val Projection_Y = projection_Y _
  val projectionY = projection_Y _
  val PROJECTION_Y = projection_Y _

}