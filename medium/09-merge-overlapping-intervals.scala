import scala.math._

object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        val func = (acc: List[(Int, Int)], curr: (Int, Int)) => {
            acc match {
                case Nil => List(curr)
                case hd :: tl =>
                    if (curr._1 <= hd._2) {
                        (hd._1, max(hd._2, curr._2)) +: tl
                    } else {
                        curr +: acc
                    }
            }
        }
        intervals.map(x => (x(0), x(1)))
                .sortBy(_._1)
                .foldLeft(List[(Int, Int)]())(func)
                .map(x => Array(x._1, x._2))
                .toArray
    }
}
