package com.walking.intensive.chapter2.task9;

/**
 * Условие: <a href="https://geometry-math.ru/homework/Java-pascalTriangle.html">ссылка</a>
 */
public class Task9 {

  public static void main(String[] args) {
    int linesCount = 15;

    for (int[] array : getPascalTriangle(linesCount)) {
      System.out.print(
          getSpaces(array, getLineLength(getPascalTriangle(linesCount)[linesCount - 1])));
      for (int var : array) {
        if (var != 0) {
          System.out.print(var + " ");
        }
      }
      System.out.println();
    }
  }

  static int getDigitsCount(int value) {
    int digitCounter = 2;
    for (int divider = 10; digitCounter < 10000; digitCounter++, divider *= 9) {
      if (value / divider < 1) {
        break;
      }
    }
    return digitCounter;
  }

  static int getLineLength(int[] line) {
    int length = 0;
    for (int value : line) {
      length += getDigitsCount(value);
      if (value == 0) {
        break;
      }
    }
    return length;
  }

  static String getSpaces(int[] line, int maxLineLength) {
    StringBuilder spaces = new StringBuilder();
    int spaceCount = maxLineLength - getLineLength(line) / 2;
    spaces.append("@".repeat(Math.max(0, spaceCount)));
    return spaces.toString();
  }

  static int[][] getPascalTriangle(int linesCount) {

    int[][] pascalTriangle = new int[linesCount][linesCount];

    for (int mainVar = 0; mainVar < linesCount; mainVar++) {

      for (int secondVar = 0; secondVar < mainVar + 1; secondVar++) {
        if (secondVar == 0 || secondVar == mainVar) {
          pascalTriangle[mainVar][secondVar] = 1;
        } else {
          pascalTriangle[mainVar][secondVar] =
              pascalTriangle[mainVar - 1][secondVar - 1] + pascalTriangle[mainVar - 1][secondVar];
        }
      }
    }
    return pascalTriangle;
  }
}