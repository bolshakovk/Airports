# Airports
Нефункциональные требования
> Перечитывать все строки файла при каждом поиске нельзя  
(в том числе читать только определенную колонку у каждой строки).

> - [x] Создавать новые файлы или редактировать текущий нельзя  
(в том числе использовать СУБД). 

> - [x] Хранить весь файл в памяти нельзя  
(не только в качестве массива байт, но и в структуре, которая так или иначе содержит все
данные из файла).

> Для корректной работы программе требуется не более 7 МБ памяти  
(все запуски java –jar должны выполняться с флагом ).

> - [x] Скорость поиска должна быть максимально высокой с учетом требований выше  
(в качестве ориентира можно взять число из скриншота выше: на поиск по «Bo», который
выдает 68 строк, требуется 25 мс).

> - [x] Сложность поиска меньше чем O(n), где n — число строк файла.

> Должны соблюдаться принципы ООП и SOLID.

> Ошибочные и краевые ситуации должны быть корректно обработаны.

> - [x] Использовать готовые библиотеки для парсинга CSV формата нельзя.

> - [x] Решенное тестовое задание — код в публичном репозитории на GitHub.
