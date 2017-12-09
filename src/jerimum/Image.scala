package jerimum

import java.awt.Graphics2D
import java.awt.image.BufferedImage

import scala.util.{ Failure, Success, Try }


import javax.imageio.ImageIO
import java.io.File

object Image {
  private[this] val empty = new Image(new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB))

  private[this] val images = collection.mutable.Map[String, Image]()
  private val lists = collection.mutable.Map[String, List[Image]]()

  def apply(road: String): Image = {
    images.get(road).getOrElse {
      Try {
        ImageIO.read(new File(road))
      } map (new Image(_, road)) match {
        case Success(img) =>
          images(road) = img
          img
        case Failure(x) => println(x); empty
      }
    }
  }

  def fatie(road: String, x: Int, y: Int) = {
    val id = s"$road $x $y"
    val l = lists.getOrElse(id, {
      val img = Image(road).buffer
      val list = for (
        j <- 0 until img.getHeight by y if (j + y <= img.getHeight);
        i <- 0 until img.getWidth by x if (i + x <= img.getWidth)
      ) yield {
        new Image(img.getSubimage(i, j, x, y))
      }
      lists(id) = list.toList
      lists(id)
    })
    List(l)
  }
}

class Image(val buffer: BufferedImage, val road: String = "") {
  def width = buffer.getWidth
  def height = buffer.getHeight

  def fatie(x: Int, y: Int) {
    val id = s"$road $x $y"
    val l = Image.lists.getOrElse(id, {
      val img = buffer
      val list = for (
        j <- 0 until img.getHeight by y if (j + y <= img.getHeight);
        i <- 0 until img.getWidth by x if (i + x <= img.getWidth)
      ) yield {
        new Image(img.getSubimage(i, j, x, y))
      }
      Image.lists(id) = list.toList
      Image.lists(id)
    })
    List(l)
  }

  private[this] def girar(g: Graphics2D, angle: Double, x: Double, y: Double, scalaX: Double, scalaY: Double)(draw: => Unit): Unit = {
    val old = g.getTransform()
    if (angle != 0.0) g.rotate(Math.toRadians(angle), x + buffer.getWidth / 2, y + buffer.getHeight / 2)
    draw
    g.setTransform(old)
  }

  def draw(x: Double, y: Double, z: Int, angle: Double = 0.0, scalaX: Double = 1.0, scalaY: Double = 1.0): Unit = {
    Draw.include(z, g => {
      girar(g, angle, x, y, scalaX, scalaY) {
        val width = (buffer.getWidth * scalaX).toInt
        val height = (buffer.getHeight * scalaY).toInt
        val deltaX = if (width < 0) -width else 0
        val deltaY = if (height < 0) -height else 0
        g.drawImage(buffer, x.toInt + deltaX, y.toInt + deltaY, width, height, null)
      }
    })
  }

  def centralized_draw(x: Double, y: Double, z: Int, angle: Double = 0.0, scalaX: Double = 1.0, scalaY: Double = 1.0) = {
    draw(x - buffer.getWidth / 2, y - buffer.getHeight / 2, z, angle, scalaX, scalaY)
  }
}