# SpringBootDemoApplication
Простое клиент-серверное приложение с использованием spring boot, hibernate

# Как вообще тут все работает?
Точка входа запускает контекст Spring Boot, который в свою очередь запускает Tomcat.
Все запросы делегируются DispatcherServlet. Он принимает все запросы и разбрасывает их с помощью Handler mappings по контроллерам.
