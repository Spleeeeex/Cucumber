# Feature: This feature verify calculation of an Isosceles Triangles in the triangle calculator
#  Scenario: Calculation by the parameters of the three sides of the triangle
#    Given I use Triangle Calculator for Test
#    When I clear all default parameters from calculator
#    And Setting value "3" for side "A"
#    And Setting value "3" for side "B"
#    And Setting value "5" for side "C"
#    And I click "Calculate" button for result
#    Then Check the triangle type is "Треугольник равнобедренный"
# language: ru

Функция: Данная функция проверяет расчет равнобедренных треугольников в калькуляторе треугольников
  Сценарий: Расчет по параметрам трех сторон треугольника
    Дано Использую калькулятор треугольника для тестирования
    Когда Очищаю параметры сторон в калькуляторе
    И Устанавливаю значение "3" для стороны "A"
    И Устанавливаю значение "3" для стороны "B"
    И Устанавливаю значение "5" для стороны "C"
    И Нажимаю на кнопку "Calculate" для получения результата
    Тогда Проверяю, что тип треугольника - "Треугольник равнобедренный"