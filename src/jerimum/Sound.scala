package jerimum



case class Sound(var file: String) {
  def toque: Unit = ()
}

case class Music(var file: String) {
  def touch(loop: Boolean = false): Unit = {
    //    Music._music = this
  }
  def tocando: Boolean = false
  def pare: Unit = ()
  def pause: Unit = ()
  def pausado: Boolean = false
}

object Music {
  private var _music: Option[Music] = None
  def current_music: Option[Music] = _music
  def current_Music = current_music
}
