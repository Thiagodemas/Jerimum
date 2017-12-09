package jerimum



case class Animation(speed: Int, images: List[Image]) {
  private[this] val start = System.currentTimeMillis()
  private[this] val size = images.length

  def imagem(): Image = {
    val indice = ((System.currentTimeMillis() - start) / speed % size).toInt
    images(indice)
  }
}