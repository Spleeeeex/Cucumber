Feature: This feature verify calculation of an Equilateral Triangles in the triangle calculator
  Scenario Outline: Calculation by the parameters of the three sides of the triangle
    Given I use Triangle Calculator
    When I clear all default parameter from calculator
    And I set value "<a>" for side "A"
    And I set value "<b>" for side "B"
    And I set value "<c>" for side "C"
    And I click "Calculate" button
    Then the triangle type is "<Type>"

    Examples:
      |a    |b    |c      |Type                      |
      |1    |1    |1      |Треугольник равносторонний|
      |1    |1    |2      |Треугольник равнобедренный|
      |100  |2    |70     |Треугольник тупоугольный  |