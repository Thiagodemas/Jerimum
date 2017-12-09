package jerimum

import java.awt.Graphics2D

import scala.util.{ Failure, Try }


object Jogo extends Runnable {
  var titulo: String = "Sem Nome"
  var largura: Int = 640
  var altura: Int = 480
  var fps: Int = 60
  private[this] var display: Tela = _
  private[this] var running = false
  private[this] var thread: Thread = _

  private[this] var desenhe, atualize = () => {}

  private[this] def init() = {
    display = new Tela(titulo, largura, altura) {
      frame.addKeyListener(Teclado)
      frame.addMouseListener(Mouse)
      frame.addMouseMotionListener(Mouse)
      canvas.addMouseListener(Mouse)
      canvas.addMouseMotionListener(Mouse)
    }
  }

  private[this] def draw() = {
    Option(display.canvas.getBufferStrategy) match {
      case None =>
        display.canvas.createBufferStrategy(3)
      case Some(strategy) => strategy.getDrawGraphics match {
        case g: Graphics2D =>
          g.clearRect(0, 0, largura, altura)
          Desenho.desenhe(g)
          strategy.show
          g.dispose()
      }
    }
  }

  override def run() = {
    init()
    val frequencia = 1000000000.0 / fps
    var delta = 0.0
    var ultimo = System.nanoTime()
    var tempo = 0L
    var ciclos = 0
    while (running) {
      val agora = System.nanoTime()
      delta += (agora - ultimo) / frequencia
      tempo += agora - ultimo
      ultimo = agora
      if (delta >= 1) {
        atualize()
        draw()
        desenhe()
        ciclos += 1
        delta -= 1
      }
      if (tempo >= 1000000000) {
        ciclos = 0
        tempo = 0
      }
    }
    parar()
  }

  def iniciar(titulo: String = "Potigol com Jerimum", largura: Int = 640,
              altura: Int = 480, atualize: => Unit = {},
              desenhe: => Unit = {}, fps: Int = 60) = synchronized {
    this.titulo = titulo
    this.largura = largura
    this.altura = altura
    this.fps = fps
    this.atualize = atualize _
    this.desenhe = desenhe _
    if (!running) {
      running = true
      thread = new Thread(this) {
        start()
      }
    }
  }

  private[this] def parar() = synchronized {
    if (running) {
      running = false
      Try(thread.join()) match {
        case Failure(e) => e.printStackTrace()
        case _          =>
      }
    }
  }

  def distância(x1: Double, y1: Double, x2: Double, y2: Double) = {
    Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
  }
  val distancia = distância _

  def projeção_X(angulo: Double, valor: Double) = {
    Math.sin(angulo * Math.PI / 180) * valor

  }

  def projeção_Y(angulo: Double, valor: Double) = {
    -Math.cos(angulo * Math.PI / 180) * valor
  }

  val projecao_X = projeção_X _
  val projeçao_X = projeção_X _
  val projecão_X = projeção_X _
  val projecao_Y = projeção_Y _
  val projeçao_Y = projeção_Y _
  val projecão_Y = projeção_Y _

}