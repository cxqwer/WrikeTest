# language: ru

@all
Функция: Базовые тесты

#  @video
  @searchTest
  Сценарий: Test Case 1. Поиск. Результаты поиска

    Когда открываем сайт "https://mtstv.mts.ru/home"
    Тогда открыто окно рекламной акции
    Когда закрываем окно рекламной акции
    Когда выполняем поиск фильма "Бумер"
    Тогда найден фильм "Бумер"