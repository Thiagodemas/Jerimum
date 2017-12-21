package exemplo
import jerimum._
import scala.util.Random
import java.awt.Color
import java.util.Random;
import scala.util.Random;
import com.sun.org.apache.bcel.internal.generic.Select


object CatchTheStars extends App {

  case class Player(var x: Double, var y: Double) {
    val img = Image("Spacecraft.png")
    var score = 0
    var vel_x, vel_y = 0.0
    var angle = 0.0

    def draw() = {
      img.centralized_draw(x, y, 3, angle)
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
      val caught = stars.filter{
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
    val images = Image.fatie("Star.png", 25, 25)
    val i = r.nextInt(images.size)

    
    
    def draw() = {
      val image = images((Clock.milisegundos / 100 + i) % images.size)
      image.centralized_draw(x, y, 1) //PROBLEMA N IDENTIFICADO 
      
    }
  }
  
  val background = Image("Space.png")
  val spacecraft = Player(game.width / 2, game.height / 2)
  var time = 0.0
  var stars = List(0, Star())
  var state = "START"
  val font = Fonts(16)

  def update() = {
    state match {
      case "START"  => update_start
      case "PLAYING" => update_playing
      case _         => update_end
    }
  }

  def draw() = {
    background.draw(0, 0, 0)
    state match {
      case "START"  => update_start
      case "PLAYING" => update_playing
      case _         => update_end
    }
  }

  // State start
  def update_start() = {
    if (Keyboard.KEY_I) state = "PLAYING"
  }

  def draw_start() = {
    val msg = "PRESS [I] TO GET STARTED"
    font.draw_centered(msg, game.width / 2, game.height / 2, 3, ColorF.YELLOW)
  }

  // State Player
  def update_playing() = {
    val r = scala.util.Random
    // eventos
    if (Keyboard.RIGHT) spacecraft.rotate_right
    if (Keyboard.LEFT) spacecraft.rotate_left
    if (Keyboard.UP) spacecraft.accelerate
    // insert new stars if necessary
    if (r.nextInt(100) < 4 && stars.size < 25) {
      stars = Star() :: stars
    }

    stars = spacecraft.catch_the_stars(stars) // Catch the stars //PROBLEMA N IDENTIFICADO 
    spacecraft.move // update player position
    time = time + 1.0 / 60.0 // increase time
    if (time.intValue() >= 30) {
      state = "END" // finish the game after 30 seconds
    }
  }

  def draw_player() = {
    spacecraft.draw
    for (star <- stars) {
      star.draw //PROBLEMA N IDENTIFICADO 
      
    }
    font.draw(s"Placar: ${spacecraft.score}", 10, 20, 3, ColorF.YELLOW)
    font.draw(s"Time: ${time.toInt}s", 10, 40, 3, ColorF.YELLOW)
  }

  // state: Game over
  def draw_end() = {
    val msg = s"GAME OVER, YOU SCORED ${spacecraft.score} POINTS"
    font.draw_centered(msg, game.width / 2, game.height / 2, 3, ColorF.YELLOW)
  }

  def update_end() = {}

  game.start("Catch the Stars", 640, 480, update, draw)

  
  }
