# TaskSHIFT

#Описание 
Эта утилита создана для того, чтобы разделить строки во входящих файлах по типам данных: строки, целые числа, вещественные числа. 
Программа запускается через файл start.bat, лежащий в папке utilityExe.

Используемая версия JDK: 23.0.1
Используемая версия Maven: Apache Maven 3.9.9
В зависимости включены junit и lombok
Полный список зависимостей:
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.36</version>
      <scope>provided</scope>
    </dependency>
#Руководство пользователя 
Для работы программы в одной папке должны находится:
1. TestTaskSHIFT.jar
2. start.bat
3. .txt файлы из которых будет происходить считывание

При запуске start.bat нужно ввести строку, минимальный запрос должен содержать имена .txt файлов, лежащих в папке utilityExe.

Так же возможно указание опций:

-o задает путь для результатов. Если вы пишете -o, то сразу после, через пробел, должен быть написан полный путь к той или иной папке.\

-p задает префикс имен выходных файлов. Если вы пишете -p, то после него, через пробел, должны написать префикс

-a режим добавления в выходные файлы. Если опция не указана, файл будет очищен и перезаписан.

-s вывод в консоль краткой статистики 

-f вывод в консоль полной статистики


Если при запуске start.bat вы видите ошибку:

![Error](https://github.com/Doath1337/TestTaskSHIFT/blob/main/pics/photo_5280715604317296685_y.jpg)

То вам нужно установить JDK 21: [Download Oracle JDK](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)

По любым вопросам работоспособности утилиты можете обращаться на:
1. alexandrkorobeinikov2@gmail.com
2. [Telegram]( https://t.me/Kill1237)
