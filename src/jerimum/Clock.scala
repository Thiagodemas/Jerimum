package jerimum
import java.util.Date


object Clock {
  private[this] val start = new Date(1, 1, 2000).getTime;
  def now: Double = new Date().getTime
  def milisegundos: Int = (System.currentTimeMillis() - start).toInt
}