# Getting Started

### Subir Base de datos
En el archivo database.sql esta el esquema y datos de pruebas para probar el api, esta es una consulta que se puede pegar en progamas como pgAdmin

### Subir Backend 
No se hicieron pruebas de subir el compilado de igual forma se desarrollo con intelliJ IDEA con java 17 desde este se puede subir el pruebas despues de configurar correctamente el archivo application.properties


### ENDPOINS
No se alcanzo a completar todas las funcionalidades que solicitadas de igual forma aca estan los endpoins del API


# neox inventory



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->
1. [user id](#1-user-id)
1. [users all](#2-users-all)
1. [product name](#3-product-name)
1. [product update](#4-product-update)
1. [product delete](#5-product-delete)
1. [product new](#6-product-new)
1. [products id](#7-products-id)
1. [products all](#8-products-all)



## Endpoints


--------



### 1. user id



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. users all



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/inventory/api/users/all
```



### 3. product name



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/inventory/api/products/name
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| value | l |  |



### 4. product update



***Endpoint:***

```bash
Method: PATCH
Type: RAW
URL: http://localhost:8080/inventory/api/products/update
```



***Body:***

```js        
{
    "productId": 1,
    "name": "Llanta",
    "quantity": 513,
    "registrationDate": "2023-08-03T05:00:00.000+00:00",
    "userId": 1
}
```



### 5. product delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/inventory/api/products/delete/6
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| userid | 1 |  |



### 6. product new



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/inventory/api/products/new
```



***Body:***

```js        
{
    "name": "Puerta",
    "quantity": 13,
    "registrationDate": "2023-09-08",
    "userId": 1
}
```



### 7. products id



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/inventory/api/products/1
```



### 8. products all



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/inventory/api/products/all
```



---
[Back to top](#neox-inventory)

