/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.reijotesti123;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Reijo
 */

public class Reijotesti123 {
  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    LocalDate christmas = LocalDate.of(today.getYear(), 12, 25);

    if (today.isAfter(christmas)) {
      christmas = christmas.plusYears(1);
    }

    long daysUntilChristmas = ChronoUnit.DAYS.between(today, christmas);
    System.out.println(daysUntilChristmas + " days until Christmas!");
  }
}



