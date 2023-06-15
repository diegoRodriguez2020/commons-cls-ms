# AddFee

Servicio encargado de calcular y actualizar una tarifa existente en la tabla **fee_detail**

> #java #spring #arquitectura hexagonal #postgres #tarifas #Centro Logísitico de Servicios

---

## Tabla de Contenido

- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Proyectos relacionados](#proyectos-relacionados)
- [Endpoints](#endpoints)
- [ApiKeys](#apiKeys)
- [Autores](#autores)
- [Licencia](#licencia)

---

## Descripción

El servicio recibe una serie de parámetros para calcular y actualizar una tarifa existente. Esta tarifa se compone de
un valor de tarifa existente, que fue previamente creado en el servicio de [AddFee](../addfee/README.md), y de una serie
de adicionales estándares y operativos reportados en la solicitud. Para el cálculo de la tarifa se realizan consultas
sobre las siguientes tablas:

- Consulta de tarifa inicial: fee_detail
- Consulta de adicionales estándar: additional_standard
- Consulta de adicionales operativos: additional_operation

Una vez la tarifa ha sido calculada, será actualizada (junto con otra información relevante) en la siguiente tabla:

- Almacenamiento de la tarifa calculada: fee_detail

---

## Detalle de Funcionalidades

### Verbo HTTP

```
PUT
```

### Path de la operación

```
/api/v1/tarifa
```

### REQUEST

```
{
    "authorizationNumber": 308,
    "standardAdditional": [
        {
            "code": "5"
        }
    ],
    "operativeAdditional": [
        {
            "code": "1"
        },
        {
            "code": "5",
            "amount": 10
        },
        {
            "code": "2",
            "amount": 10
        }
    ]
}
```

### RESPONSE OK

```
{
    "authorizationNumber": 308,
    "initialFee": "329500.00",
    "additionalStandardFee": "12000.00",
    "additionalOperationsFee": "271000.00",
    "totalFee": "612500.00"
}
```

### RESPONSE ERROR

```

```

## Proyectos relacionados

A continuación se detallan los módulos o funcionalidades que usan los servicios contenidos en este micro-servicio:

### cls-fee-management-frontend

- URL de
  Github:  [Repositorio](https://github.com/segurosbolivar/cls-fee-management-frontend)

---

## Endpoints

- **DEV** (Abierto a consumo)
    - https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/fee_management/api/v1/tarifa

- **STAGE**
    - https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/fee_management/api/v1/tarifa

- **PROD**
    - https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/fee_management/api/v1/tarifa

---

## ApiKeys

El x-api-key se debe enviar en el header de la petición

- **DEV**
    - x-api-key: Por definir
- **STAGE**
    - x-api-key: Por definir

## Autores

El equipo involucrado en la implementación del componente se detalla a continuación:

- Equipo de Desarrollo:
    - Darwin D. Galván H. <darwin.galvan@insoftar.com>
    - Danilo A. Puentes O. <danilo.puentes@insoftar.com>
    - Jhonatan A. Rodriguez C. <jhonatan.rodriguez@insoftar.com>
    - Diego H. Rodríguez G. <diego.rodriguez@insoftar.com>
- Líder Técnico:
    - Johan Terranova U. <johan.terranova@segurosbolivar.com>
- Arquitecto de TI:
    - Eduar S. Bohorquez B. <eduar.bohorquez@samtel.co>

---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)

- Copyright 2023 ©