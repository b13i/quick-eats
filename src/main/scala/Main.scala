import Extract.Extractor

object Main {
  def main(args: Array[String]): Unit = {
    val recipeURLs = Extractor.extractRecipeURLs()
    Utils.writeIterableToFile(path="./src/main/resources/new_york_times_urls.txt", contents=recipeURLs)
  }
}
