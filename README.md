# cls-fee-management [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=segurosbolivar_cls-fee-management&metric=alert_status&token=2913466692e89eacf4d01c2eeb776f06f688ab54)](https://sonarcloud.io/summary/new_code?id=segurosbolivar_cls-fee-management) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=segurosbolivar_comunes-documentos-firma-electronica-core-lambda&metric=coverage&token=c5372c621b1f455a33f3f943ea2b16c69377394a)](https://sonarcloud.io/summary/new_code?id=segurosbolivar_comunes-documentos-firma-electronica-core-lambda)

# NOTA: coverage de ejemplo NO VÁLIDO porque aún no se evidencia en sonar

Expone una API relacionada al cálculo de tarifas para los servicios correspondientes al Centro Logísticos de Servicios.

> #java #spring #arquitectura hexagonal #postgres #tarifas #Centro Logísitico de Servicios

---

## Tabla de Contenido

- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Endpoints](#endpoints)
- [Licencia](#licencia)

---

## Descripción

Provee servicios para el cálculo de tarifas de los servicios prestados por el Centro Logístico de Servicios

---

## Detalle de Funcionalidades

- [AddFee](domain/usecase/src/main/java/com/cls/domain/ports/addfee/README.md)
- [UpdateFee](domain/usecase/src/main/java/com/cls/domain/ports/updatefee/README.md)

## Desarrollo

### Ejecución en local

#### Modificar [application.yaml](application/application-service/src/main/resources/application.yaml)

```
server:
  port: 8080
```

Ubicar y configurar server-port en 8080 o en cualquier otro puerto de su preferencia

```
spring:
  datasource:
    url: jdbc:postgresql://host:port/namedatabase?currentSchema=logistica
    username: username
    password: password
```

Ubicar y configurar spring-datasource por los parámetros solicitados por el Líder Técnico del proyecto

## Construido con

El código Se encuentra implementado con [Spring Boot](https://spring.io/projects/spring-boot) y Java 11 usando las
siguientes librerias:

- [OpenAPI 3 con spring-boot](https://springdoc.org/) - Para documentación del servicio.
- [Jacoco](https://docs.gradle.org/current/userguide/jacoco_plugin.html) - Cobertura de código

## Endpoints

- **DEV** (Abierto a consumo)
    - https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/fee_management

- **STAGE**
    - https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/fee_management

- **PROD**
    - https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/fee_management

---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)

- Copyright 2023 ©