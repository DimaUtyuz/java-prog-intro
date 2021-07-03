
# Учебные проекты по курсу "Введение в программирование"

[Основная страница курса](http://www.kgeorgiy.info/courses/prog-intro/homeworks.html)

## Памятка

Все решения реализованы на языке программирования Java. 

В решениях реализованы сложные модификации (38-39 группы).

### Список условий:   
 
#### [1. Свой сканер](#домашнее-задание-1-свой-сканер)

#### [2. Статистика слов++](#домашнее-задание-2-статистика-слов)

#### [3. Разметка](#домашнее-задание-3-разметка)

#### [4. Игра m,n,k](#домашнее-задание-4-игра-mnk)

#### [5. Выражения](#домашнее-задание-5-выражения)

#### [6. Разбор выражений](#домашнее-задание-6-разбор-выражений)

#### [7. Обработка ошибок](#домашнее-задание-7-обработка-ошибок)

### Домашнее задание 1. Свой сканер

1.  Реализуйте свой аналог класса `Scanner` на основе `Reader`.
2.  Примените разработанный `Scanner` для решения задания «Реверс».
3.  Примените разработанный `Scanner` для решения задания «Статистика слов».
4.  Код, управляющий чтением должен быть общим.
5.  _Сложный вариант_. Код, выделяющий числа и слова должен быть общим.
6.  При реализации блочного чтения обратите внимание на слова/числа, пересекающие границы блоков, особенно — больше одного раза.
7.  Модификация *HexAbc*
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Десятеричные числа могут быть записаны буквами
    * Класс должен иметь имя `ReverseHexAbc`
    * [Исходный код тестов](java/reverse/FastReverseHexAbcTest.java)
    * [Откомпилированные тесты](artifacts/reverse/FastReverseHexAbcTest.jar)

### Домашнее задание 2. Статистика слов++

1.  Разработайте класс `WordStatIndex`, который будет подсчитывать статистику встречаемости слов во входном файле.
2.  Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.
3.  Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.
4.  Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.
5.  Программа должна работать за линейное от размера входного файла время.
6.  Для реализации программы используйте Collections Framework.
7.  _Сложный вариант._ Реализуйте и примените класс `IntList`, компактно хранящий список целых чисел.

Модификация *CountFirstIndex*
    * В выходном файле слова должны быть упорядочены по возрастанию числа
      вхождений, а при равном числе вхождений – по порядку первого вхождения
      во входном файле.
    * Вместо номеров вхождений во всем файле надо указывать
      только первое вхождение в каждой строке
    
### Домашнее задание 3. Разметка

1.  Разработайте набор классов для текстовой разметки.
2.  Класс Paragraph может содержать произвольное число других элементов разметки и текстовых элементов.
3.  Класс Text – текстовый элемент.
4.  Классы разметки Emphasis, Strong, Strikeout – выделение, сильное выделение и зачеркивание. Элементы разметки могут содержать произвольное число других элементов разметки и текстовых элементов.
5.  Все классы должны реализовывать метод toMarkdown([StringBuilder](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuilder.html)), которой должен генерировать [Markdown](https://ru.wikipedia.org/wiki/Markdown)\-разметку по следующим правилам:
    1.  текстовые элементы выводятся как есть;
    2.  выделенный текст окружается символами '\*';
    3.  сильно выделенный текст окружается символами '\_\_';
    4.  зачеркнутый текст окружается символами '~'.
6.  Следующий код должен успешно компилироваться:
    
        Paragraph paragraph = new Paragraph(List.of(
            new Strong(List.of(
                new Text("1"),
                new Strikeout(List.of(
                    new Text("2"),
                    new Emphasis(List.of(
                        new Text("3"),
                        new Text("4")
                    )),
                    new Text("5")
                )),
                new Text("6")
            ))
        ));
    
    Вызов paragraph.toMakdown(new StringBuilder()) должен заполнять переданный StringBuilder следующим содержимым:
    
        __1~2*34*5~6__
    
7.  Разработанные классы должны находиться в пакете markup.

Модификация *BBCodeList*
    * Дополнительно реализуйте метод `toBBCode`, генерирующий [BBCode](https://en.wikipedia.org/wiki/BBCode)-разметку:
      * выделеный текст окружается тегом `i`;
      * сильно выделеный текст окружается тегом `b`;
      * зачеркнутый текст окружается тегом `s`.
    * Добавьте поддержку:
      * Нумерованных списков (класс `OrderedList`, тег `list=1`): последовательность элементов
      * Ненумерованных списков (класс `UnorderedList`, тег `list`): последовательность элементов
      * Элементов списка (класс `ListItem`, открывающий тег `*`): последовательность абзацев и списков

### Домашнее задание 4. Игра m,n,k

1.  Реализуйте [игру m,n,k](https://en.wikipedia.org/wiki/M,n,k-game).
2.  Добавьте обработку ошибок ввода пользователя.
3.  _Сложная версия_.
    *   Проверку выигрыша нужно производить за _O(k)_.
    *   Предотвратите жульничество: у игрока не должно быть возможности достать `Board` из `Position`.
4.  _Бонусная версия_. Реализуйте `Winner` — игрок, который выигрывает всегда, когда это возможно (против любого соперника).

Модификация *Дополнительные ходы и ромб* (38, 39)
    * Добавить поддержку доски в форме ромба (квадрата, повернутого на 45°)
    * Если в результате хода игрока на доске появляется новая последовательность
      из 4+ одинаковых символов, то он делает дополнительный ход
    * Игрок может сделать несколько дополнительных ходов подряд

### Домашнее задание 5. Выражения

1.  Разработайте классы `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, `Divide` для вычисления выражений с одной переменной в типе `int`.
2.  Классы должны позволять составлять выражения вида
    
    new Subtract(
        new Multiply(
            new Const(2),
            new Variable("x")
        ),
        new Const(3)
    ).evaluate(5)
                
    
    При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу `evaluate` (на данном этапе имена переменных игнорируются). Таким образом, результатом вычисления приведенного примера должно стать число 7.
3.  Метод `toString` должен выдавать запись выражения в полноскобочной форме. Например
    
    new Subtract(
        new Multiply(
            new Const(2),
            new Variable("x")
        ),
        new Const(3)
    ).toString()
                
    
    должен выдавать `((2 * x) - 3)`.
4.  _Сложный вариант._ Метод `toMiniString` должен выдавать выражение с минимальным числом скобок. Например
    
    new Subtract(
        new Multiply(
            new Const(2),
            new Variable("x")
        ),
        new Const(3)
    ).toMiniString()
                
    
    должен выдавать `2 * x - 3`.
5.  Реализуйте метод `equals`, проверяющий, что два выражения совпадают. Например,
    
    new Multiply(new Const(2), new Variable("x"))
        .equals(new Multiply(new Const(2), new Variable("x")))
                
    
    должно выдавать `true`, а
    
    new Multiply(new Const(2), new Variable("x"))
        .equals(new Multiply(new Variable("x"), new Const(2)))
                
    
    должно выдавать `false`.
6.  При выполнении задания следует обратить внимание на:
    *   Выделение общего интерфейса создаваемых классов.
    *   Выделение абстрактного базового класса для бинарных операций.

Модификация *DoubleTriple* (38, 39)
    * Дополнительно реализуйте интерфейсы 
      [DoubleExpression](java/expression/DoubleExpression.java) и
      [TripleExpression](java/expression/TripleExpression.java)

### Домашнее задание 6. Разбор выражений

1.  Доработайте предыдущее домашнее задание, так что бы выражение строилось по записи вида
    
    x \* (x - 2)\*x + 1
    
2.  В записи выражения могут встречаться: умножение `*`, деление `/`, сложение `+`, вычитание `-`, унарный минус `-`, целочисленные константы (в десятичной системе счисления, которые помещаются в 32-битный знаковый целочисленный тип), круглые скобки, переменные (`x`) и произвольное число пробельных символов в любом месте (но не внутри констант).
3.  Приоритет операторов, начиная с наивысшего
    1.  унарный минус;
    2.  умножение и деление;
    3.  сложение и вычитание.
4.  Разбор выражений рекомендуется производить [методом рекурсивного спуска](https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D1%80%D0%B5%D0%BA%D1%83%D1%80%D1%81%D0%B8%D0%B2%D0%BD%D0%BE%D0%B3%D0%BE_%D1%81%D0%BF%D1%83%D1%81%D0%BA%D0%B0). Алгоритм должен работать за линейное время.

Модификация *FlipLow и Bitwise*
    * Дополнительно реализуйте бинарные операции:
        * `&` – побитное И, приоритет меньше чем у `+` (`6 & 1 + 2` равно `6 & (1 + 2)` равно 2);
        * `^` – побитный XOR, приоритет меньше чем у `&` (`6 ^ 1 + 2` равно `6 ^ (1 + 2)` равно 5);
        * `|` – побитное ИЛИ, приоритет меньше чем у `^` (`6 | 1 + 2` равно `6 | (1 + 2)` равно 7);
    * Дополнительно реализуйте унарные операции (приоритет как у унарного минуса):
        * `flip` – число с переставленными двоичными цифрами, `flip 12345` равно 9987, 
                   `flip -12345` равно `-470548481`;
        * `low` – минимальный установленный бит
                 (как в [lowestOneBit](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html#lowestOneBit%28int%29)),
                 `low 123456` равно 64.

### Домашнее задание 7. Обработка ошибок

1.  Добавьте в программу вычисляющую выражения обработку ошибок, в том числе:
    *   ошибки разбора выражений;
    *   ошибки вычисления выражений.
2.  При выполнении задания следует обратить внимание на дизайн и обработку исключений.
3.  Человеко-читаемые сообщения об ошибках должны выводится на консоль.
4.  Программа не должна «вылетать» с исключениями (как стандартными, так и добавленными)

Модификация *GcdLcm и AbsSqrt*
    * Дополнительно реализуйте унарные операции:
        * `abs` – модуль числа, `abs -5` равно 5;
        * `sqrt` – квадратный корень, `sqrt 24` равно 4.
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `gcd` – НОД, `2 gcd -3` равно 1;
        * `lcm` – НОК, `2 lcm -3` равно -6.
