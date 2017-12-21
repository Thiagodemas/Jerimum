package jerimum



case class Animation(speed: Int, images: List[Image]) {
  private[this] val start = System.currentTimeMillis()
  private[this] val size = images.length

  def image(): Image = {
    val index = ((System.currentTimeMillis() - start) / speed % size).toInt
    images(index)
  }
}