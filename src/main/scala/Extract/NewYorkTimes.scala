package Extract

import java.net.{URL, UnknownHostException}

import net.ruippeixotog.scalascraper.browser.Browser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

// TODO: use URL library, HTML selector library
case class NewYorkTimes(browser: Browser) extends Website {
  override val name = "The New York Times" // TODO: override necessary?
  val hostname = "http://cooking.nytimes.com"
  val recipe_selector = "div.card-info-wrapper>a.card-link"
  val paginate = paginator()

  override def collectRecipeUrls(accumulator: Iterable[URL]): Iterable[URL] = {
    println(s"accumulator=$accumulator")

    try {
      val searchUrl = paginate().toString
      println(s"Collecting recipe urls for searchUrl=$searchUrl")
      browser.get(searchUrl)
        .>?>(extractor[Iterable[String], Iterable[URL]](
          recipe_selector, attrs("href"), paths => paths.map(path => new URL(s"$hostname$path"))
        ))
        .fold(accumulator)(urls => collectRecipeUrls(urls ++ accumulator))
    } catch {
      case uhe: UnknownHostException =>
        println("Unknown host")
        accumulator
    }
  }

  override def extractRecipe(url: URL): Option[Recipe] = ???

  override def extractRecipes(urls: Seq[URL]): Option[Seq[Recipe]] = ???

  override def getSearchURL(pageNum: Int): URL = {
    new URL(s"$hostname?page=$pageNum")
  }
}
