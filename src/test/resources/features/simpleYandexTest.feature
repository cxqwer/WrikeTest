# language: ru

@all
Функция: Базовые тесты yandex

  @yandexSearch
  Сценарий: Test Case 1. Выполнение поиска
    
    Когда открываем сайт "https://yandex.ru/"
    Тогда открыт сайт яндекса. Отображается поле поиска
    Когда в поле поиска вводим "Шляпа"
    И нажимаем кнопку поиска
    Тогда по запросу найдена информация