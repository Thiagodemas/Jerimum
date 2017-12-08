package jerimum



case class Som(var arquivo: String) {
  def toque: Unit = ()
}

case class Musica(var arquivo: String) {
  def toque(loop: Boolean = false): Unit = {
    //    Musica._musica = this
  }
  def tocando: Boolean = false
  def pare: Unit = ()
  def pause: Unit = ()
  def pausado: Boolean = false
}

object Musica {
  private var _musica: Option[Musica] = None
  def musica_atual: Option[Musica] = _musica
  def música_atual = musica_atual
}
