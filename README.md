# Airports
Нефункциональные требования
> - [x] Перечитывать все строки файла при каждом поиске нельзя  
(в том числе читать только определенную колонку у каждой строки).

В каждой ячейке присвоена определенная колонка. Поиск проходит единожды при запуске и вызывается метод поиска при вводе валидного текста

> - [x] Создавать новые файлы или редактировать текущий нельзя  
(в том числе использовать СУБД). 

Не использовалась субд, файл CSV не редактирован

> - [x] Хранить весь файл в памяти нельзя  
(не только в качестве массива байт, но и в структуре, которая так или иначе содержит все
данные из файла).

Файл в памяти не хранится, но значения записываются в ArrayList.

> Для корректной работы программе требуется не более 7 МБ памяти  
(все запуски java –jar должны выполняться с флагом ).
При сборке, создал название артифакта Airport, с версированием 1.0-SNAPSHOT. Создан джарник mvn clean pacage c требуемым флагом
![image](https://user-images.githubusercontent.com/71641509/183873506-4d2aa1d4-6e3a-434d-a85e-c462d8e57189.png)
Столкнулся с трудностями такими как: невозможность найти мейн класс(решил прописанием его в манифесте). И доступом к исполняемому файлу(был конфликт JRE JDK). Запускал и работал через Intellij Idea


> - [x] Скорость поиска должна быть максимально высокой с учетом требований выше  
(в качестве ориентира можно взять число из скриншота выше: на поиск по «Bo», который
выдает 68 строк, требуется 25 мс).
![image](https://user-images.githubusercontent.com/71641509/183874270-8c349414-8879-4d7a-a941-483ff984dfe6.png)


Скорость работы замерена и протестирована на примере

> - [x] Сложность поиска меньше чем O(n), где n — число строк файла.

Поиск элемента соответствует O(n) т.к. проход по элементам идет один раз.

> - [x] Должны соблюдаться принципы ООП и SOLID.

Реализован класс, реализован метод поиска, реализована структура хранения. 

> - [x] Ошибочные и краевые ситуации должны быть корректно обработаны.

Реализованы юнит-тесты

> - [x] Использовать готовые библиотеки для парсинга CSV формата нельзя.

Не использовались

> - [x] Решенное тестовое задание — код в публичном репозитории на GitHub.

Так как в задании написано что не важно за что отвечают колонки, присвоил значения только названий, айди, города и страны где находится аэропорт для большей репрезентабельности.
