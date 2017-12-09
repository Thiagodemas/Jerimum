package jerimum


import scala.io.Source

object File {
  def read(road: String) {
    List(Source.fromFile(road).getLines().toList)
  }
}