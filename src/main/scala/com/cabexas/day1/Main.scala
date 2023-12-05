package com.cabexas

import scala.io.Source
import scala.util.Using
import scala.util.Try
import scala.util.matching.Regex
import scala.util.matching.Regex.Match

def lines = readFile("src/main/resources/day1.txt").linesIterator

def part1(input: Iterator[String]) = {
  val regex = "[0-9]".r
  input
    .map: line =>
      val matches = regex
        .findAllMatchIn(line)
        .map(_.matched.toInt)
        .toList
      val firstDigit = matches.head
      val lastDigit = matches.last
      firstDigit * 10 + lastDigit
    .toList
}

val translation = Map[String, Int](
  "one" -> 1,
  "two" -> 2,
  "three" -> 3,
  "four" -> 4,
  "five" -> 5,
  "six" -> 6,
  "seven" -> 7,
  "eight" -> 8,
  "nine" -> 9
)

def part2(input: Iterator[String]): List[Int] = {
  val regex: Regex = "[0-9]|one|two|three|four|five|six|seven|eight|nine".r

  input
    .map: line =>
      val matches = regex
        .findAllMatchIn(line)
        .map: m =>
          translation
            .get(m.matched)
            .getOrElse(m.matched.toInt)
        .toList
      val firstDigit = matches.head
      val lastDigit = matches.last
      firstDigit * 10 + lastDigit
    .toList

}

@main def main: Unit = {
  println(s"Calibration values sum: [${part1(lines).sum}]")
  println(s"Calibration values sum: [${part2(lines).sum}]")
}

//Using ensures file is closed
def readFile(path: String) = Using.resource(Source.fromFile(path))(_.mkString)
