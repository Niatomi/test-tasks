## Инструкция по сборке и запуску
Запуск и сборка первой части 
```shell
..> cd test-tasks
../test-tasks> cd task1
../test-tasks/task1> mvn clean compile package
../test-tasks/task1> cd target
../test-tasks/task1/target> java -jar task1-1.0-SNAPSHOT.jar
```
Запуск и сборка второй части
```
..> cd test-tasks
../test-tasks> cd task2
../test-tasks/task2> mvn clean compile package
../test-tasks/task2> cd target
../test-tasks/task2/target> java -jar task2-1.0-SNAPSHOT.jar
```
Запуск при помощи docker-compose
```shell
..> cd test-tasks
../test-tasks> docker-compose up --build
```