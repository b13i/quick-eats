import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object Utils {
  def writeToFile(path: String, contents: String) =
    Files.write(Paths.get(path), contents.getBytes(StandardCharsets.UTF_8))

  def writeIterableToFile[A](path: String, contents: Iterable[A]) =
    writeToFile(path, contents.map(_.toString).mkString("\n"))
}
