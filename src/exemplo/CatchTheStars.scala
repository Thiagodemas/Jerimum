package exemplo
import jerimum._
import scala.util.Random
import java.awt.Color
import java.util.Random;
import scala.util.Random;


object CatchTheStars extends App {

  case class Player(var x: Double, var y: Double) {
    val image = Image("Nave.png")
    var score = 0
    var vel_x, vel_y = 0.0
    var angle = 0.0

    def draw() = {
      image.centralized_draw(x, y, 3, angle)
    }

    def rotate_right() = {
      angle = angle + 5.0
    }

    def rotate_left() = {
      angle = angle - 5.0
    }

    def accelerate() = {
      vel_x = vel_x + Game.Projection_X(angle, 0.5)
      vel_y = vel_y + Game.Projection_Y(angle, 0.5)
    }

    def move() = {
      x = x + vel_x
      y = y + vel_y
      x = (game.width + x) % game.width
      y = (game.height + y) % game.height
      vel_x = vel_x * 0.95
      vel_y = vel_y * 0.95
    }

    def catch_the_stars(stars: List[Star]) = {
      val caught = stars.select {
        star => Game.distance(x, y, star.x, star.y) >= 35
      }
      val n = stars.size - caught.size
      score = score + n * 10
      caught
    }
  }

  case class Star() {
    val r = scala.util.Random
    val x = r.nextInt(game.width)
    val y = r.nextInt(game.height)
    val color = ColorF(r.nextInt(216) + 40, r.nextInt(216) + 40, r.nextInt(216) + 40)
    val images = Image.fatie("Estrela.png", 25, 25)
    val i = r.nextInt(images.size)

/*    
    
    def draw() = {
      val image = images((Clock.milisegundos / 100 + i) % images.size)
      image.centralized_draw(x, y, 1)
    }
  }
  
  val imagem_fundo = Imagem("Space.png")
  val nave = Jogador(jogo.largura / 2, jogo.altura / 2)
  var tempo = 0.0
  var estrelas = List(0, Estrela())
  var estado = "INICIO"
  val fonte = Fonte(16)

  def atualize() = {
    estado match {
      case "INICIO"  => atualize_inicio
      case "JOGANDO" => atualize_jogando
      case _         => atualize_fim
    }
  }

  def desenhe() = {
    imagem_fundo.desenhe(0, 0, 0)
    estado match {
      case "INICIO"  => desenhe_inicio
      case "JOGANDO" => desenhe_jogando
      case _         => desenhe_fim
    }
  }

  // Estado Inicio
  def atualize_inicio() = {
    if (Teclado.TECLA_I) estado = "JOGANDO"
  }

  def desenhe_inicio() = {
    val msg = "PRESSIONE [ I ] PARA COMEÇAR"
    fonte.desenhe_centralizado(msg, jogo.largura / 2, jogo.altura / 2, 3, Cor.AMARELO)
  }

  // Estado Jogando
  def atualize_jogando() = {
    // eventos
    if (Teclado.TECLA_PARA_DIREITA) nave.girar_direita
    if (Teclado.TECLA_PARA_ESQUERDA) nave.girar_esquerda
    if (Teclado.TECLA_PARA_CIMA) nave.acelerar
    // inserir novas estrelas estrelas se necessario
    if (Random(100) < 4 && estrelas.size < 25) {
      estrelas = Estrela() :: estrelas
    }

    estrelas = nave.catar_estrelas(estrelas) // catar estrelas
    nave.mover // atualizar a posicao do jogador
    tempo = tempo + 1.0 / 60.0 // incrementar o tempo
    if (tempo.inteiro >= 30) {
      estado = "FIM" // terminar o jogo depois de 30 segundos
    }
  }

  def desenhe_jogando() = {
    nave.desenhe
    for (estrela <- estrelas) {
      estrela.desenhe
    }
    fonte.desenhe(s"Placar: ${nave.placar}", 10, 20, 3, Cor.AMARELO)
    fonte.desenhe(s"Tempo: ${tempo.toInt}s", 10, 40, 3, Cor.AMARELO)
  }

  // Estado: fim do jogo
  def desenhe_fim() = {
    val msg = s"FIM DE JOGO, VOCE FEZ ${nave.placar} PONTOS"
    fonte.desenhe_centralizado(msg, jogo.largura / 2, jogo.altura / 2, 3, Cor.AMARELO)
  }

  def atualize_fim() = {}

  jogo.iniciar("Cata Estrelas", 640, 480, atualize, desenhe)
*/
  
  }
