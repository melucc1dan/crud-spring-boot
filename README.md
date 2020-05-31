# CRUD REST SPRING BOOT

Aplicación REST con Spring Boot para acceder a registros de Mysql y realizar operaciones de tipo CRUD, prescindiendo de Thymeleaf o cualquier otro motor de plantillas para enfocarse en la parte backend de la misma. El objetivo es demostrar conocimientos __básicos__ sobre este tipo de proyectos.

Detalles del código:
* Apache POI es utilizada para almacenar y efectuar la descarga de los registros en formato .xls
* A través del patrón de diseño DTO (Data Transfer Object) se logra recuperar información de múltiples fuentes (tablas pertenecientes a la base de datos utilizada) y luego se genera una consulta utilizando JOIN.
* Las consultas escritas en FacturaRepository presentan dos formatos distintos; *JPQL y nativeQuery*.
