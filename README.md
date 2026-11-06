🍔 Delivery Service Backend
Java
Spring Boot
Maven
Учебный бэкенд-сервис для платформы доставки еды, разработанный в рамках подготовки к курсу Java Advanced и техническим собеседованиям.
————
🚀 Стек технологий
- Язык: Java 17
- Фреймворк: Spring Boot 3 (Spring Core, IoC, DI)
- Сборщик: Maven
- Архитектура: Слоеная архитектура (Controller ➔ Service ➔ Repository)
————
📌 Архитектурные особенности
- Inversion of Control & Dependency Injection: Полный отказ от антипаттерна Field Injection (@Autowired над полями). Внедрение зависимостей реализовано строго через конструкторы с модификатором final для обеспечения неизменяемости (immutability).
- Слабое зацепление (Loose Coupling): Сервисы зависят от абстракций (интерфейсов PaymentProcessor), а не от конкретных реализаций (принцип Dependency Inversion из SOLID).
————
🛠 Быстрый запуск
1. Клонирование репозитория
git clone https://github.com/твой-логин/delivery-service.git
cd delivery-service
2. Запуск приложения через Maven Wrapper
- Windows:
  
.\mvnw.cmd spring-boot:run
- Linux / macOS:
  
./mvnw spring-boot:run
————
👨‍💻 Автор
- GitHub: @pyfas78
