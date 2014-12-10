package nazotoki

/**
 * Created by sakamoto on 2014/12/10.
 */
class Test {

  abstract class Hoge(name: String)

  case class Sakamoto(name: String) extends Hoge(name)

}
