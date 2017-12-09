package jerimum



case class Animacao(velocidade: Int, imagens: List[Image]) {
  private[this] val inicio = System.currentTimeMillis()
  private[this] val tamanho = imagens.length

  def imagem(): Image = {
    val indice = ((System.currentTimeMillis() - inicio) / velocidade % tamanho).toInt
    imagens(indice)
  }
}