package com.cabexas.day1

import com.cabexas.part2

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class Day1 extends munit.FunSuite {

  test("string only contains one digit") {
    val input = Iterator("one")
    assertEquals(part2(input), List(11))

    val input2 = Iterator("kjk4jkjk")
    assertEquals(part2(input2), List(44))

    val input3 = Iterator("kjkjkjkseven")
    assertEquals(part2(input3), List(77))
  }

  test("string only contains two digits") {
    val input = Iterator("1kjkjkj4k")
    assertEquals(part2(input), List(14))

    val input2 = Iterator("kjk4jkjk8")
    assertEquals(part2(input2), List(48))

    val input3 = Iterator("6kjkjkjk7")
    assertEquals(part2(input3), List(67))

    val input4 = Iterator("kj3kjk5jk")
    assertEquals(part2(input4), List(35))
  }

  test("string contains more than two digits") {
    val input = Iterator("1kjk3jkj4k")
    assertEquals(part2(input), List(14))

    val input2 = Iterator("kjk4jk5jk8")
    assertEquals(part2(input2), List(48))

    val input3 = Iterator("6kjk7jkj4k7")
    assertEquals(part2(input3), List(67))

    val input4 = Iterator("kj3kj9k58jk")
    assertEquals(part2(input4), List(38))
  }

  test("overlapping matches") {
    val input = Iterator("oneight")
    assertEquals(part2(input), List(18))
  }
}
