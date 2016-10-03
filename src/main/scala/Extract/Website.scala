package Extract

import java.net.URL

case class Recipe(content: String)

trait Website {
  val name: String
  def collectRecipeUrls(accumulator: Iterable[URL]): Iterable[URL]
  def extractRecipe(url: URL): Option[Recipe]
  def extractRecipes(urls: Seq[URL]): Option[Seq[Recipe]]
  def paginator(): () => URL = {
    var i = 0

    () => {
      i += 1
      getSearchURL(i)
    }
  }
  def getSearchURL(pageNum: Int): URL = ???
}
