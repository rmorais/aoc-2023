package com.cabexas

import scala.io.Source
import scala.util.Using
import scala.util.Try

val lines = readFile("src/main/resources/day1.txt").linesIterator

val findCalibrationValues: List[Int] = {
  val builder = List.newBuilder[Int]
  var firstDigit = 'a'
  var lastDigit = 'a'
  for (line <- lines) {
    for (char <- line) {
      Try(Integer.parseInt(char.toString())).map { d =>
        if firstDigit == 'a' then
          firstDigit = char
        lastDigit = char
      }
    }
    builder.addOne((s"$firstDigit$lastDigit").toInt)
    firstDigit = 'a'
    lastDigit = 'a'
  }

  builder.result()
}

@main def part1: Unit ={
  println(s"Calibration values sum: [${findCalibrationValues.sum}]")
}

//Using ensures file is closed
def readFile(path: String) = Using.resource(Source.fromFile(path))(_.mkString)
