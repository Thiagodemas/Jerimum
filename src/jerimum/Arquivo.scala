package jerimum


import scala.io.Source

object Arquivo {
  def leia(caminho: String) {
    List(Source.fromFile(caminho).getLines().toList)
  }
}