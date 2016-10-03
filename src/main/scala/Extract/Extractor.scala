package Extract

import java.net.URL

import net.ruippeixotog.scalascraper.browser.JsoupBrowser

object Extractor {
  val browser = JsoupBrowser()

  def extractRecipeURLs(): Iterable[URL] = {
    println("Extracting recipe URLs...")
    NewYorkTimes(browser).collectRecipeUrls(Seq())
  }
}
