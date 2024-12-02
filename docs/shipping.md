### Listar / Pequisar pelo código do Rastreio

Lista todos os dados com base no id do envio, aqui também é possivel verificar as informações de rastreio

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/shippings`
- **Código HTTP:** `200 OK`

#### Parâmetro
| **Campo**  | **Tipo**    | **Descrição**      | **Requerido** | **Enum**                    | 
|------------|-------------|--------------------|---------------|-----------------------------|
| shippingId | String      | Código do Rastreio | Não            |                             |

```shell
curl --location 'http://localhost:8084/api/v1/shippings?size=3'
```
OU
```shell
curl --location 'http://localhost:8084/api/v1/shippings/66434921-95d5-4160-ba0c-53d2a51f40a5'
```
    GET  api/v1/shippings/{id}

#### Exemplo de resposta de sucesso (Lista)

```json
{
    "content": [
        {
            "trackingId": "0813571b-001d-4baa-b7db-dc8758d88114",
            "latitude": -79.76886537303861,
            "longitude": -97.56009078768177,
            "carrier": {
                "code": 18,
                "name": "Recife",
                "zipCodeStart": 50000000,
                "zipCodeEnd": 52999999
            }
        },
        {
            "trackingId": "4ff64707-4cd8-44dd-a4cb-ce3f606a3c9f",
            "latitude": 59.51931265376072,
            "longitude": -138.75334625535908,
            "carrier": {
                "code": 4,
                "name": "SP_Interior",
                "zipCodeStart": 12000000,
                "zipCodeEnd": 19999999
            }
        },
        {
            "trackingId": "cd444211-92d7-40ed-aa25-d4904cb78698",
            "latitude": 84.21588752071258,
            "longitude": -141.8599606644175,
            "carrier": {
                "code": 4,
                "name": "SP_Interior",
                "zipCodeStart": 12000000,
                "zipCodeEnd": 19999999
            }
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 3,
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 6,
    "totalElements": 17,
    "first": true,
    "size": 3,
    "number": 0,
    "sort": {
        "empty": true,
        "unsorted": true,
        "sorted": false
    },
    "numberOfElements": 3,
    "empty": false
}
```

#### Exemplo de resposta de sucesso (Por Tracking ID)

```json
{
  "content": [
    {
      "id": "66434921-95d5-4160-ba0c-53d2a51f40a5",
      "orderCode": "TST-000012",
      "recipient": "Teste",
      "status": "Pedido com a Transpostadora",
      "shippingDate": "2024-12-02",
      "deliveryDate": null,
      "tracking": {
        "trackingId": "4ff64707-4cd8-44dd-a4cb-ce3f606a3c9f",
        "latitude": 59.51931265376072,
        "longitude": -138.75334625535908,
        "carrier": {
          "code": 4,
          "name": "SP_Interior",
          "zipCodeStart": 12000000,
          "zipCodeEnd": 19999999
        }
      },
      "address": {
        "street": "Teste",
        "number": 123,
        "complement": null,
        "city": "Americana",
        "neighborhood": "Teste",
        "state": "SP",
        "zipCode": 13470160,
        "country": "Brazil",
        "phone": "19991238899"
      },
      "products": [
        {
          "code": "TESTE000001",
          "quantity": "1"
        },
        {
          "code": "TESTE000002",
          "quantity": "1"
        },
        {
          "code": "TESTE000003",
          "quantity": "1"
        }
      ]
    },
    {
      "id": "520e16ae-79d9-4908-8e9f-0e790ace7a61",
      "orderCode": "TST-000012",
      "recipient": "Teste",
      "status": "Pedido com a Transpostadora",
      "shippingDate": "2024-12-02",
      "deliveryDate": null,
      "tracking": {
        "trackingId": "cd444211-92d7-40ed-aa25-d4904cb78698",
        "latitude": 84.21588752071258,
        "longitude": -141.8599606644175,
        "carrier": {
          "code": 4,
          "name": "SP_Interior",
          "zipCodeStart": 12000000,
          "zipCodeEnd": 19999999
        }
      },
      "address": {
        "street": "Teste",
        "number": 123,
        "complement": null,
        "city": "Americana",
        "neighborhood": "Teste",
        "state": "SP",
        "zipCode": 13470160,
        "country": "Brazil",
        "phone": "19991238899"
      },
      "products": [
        {
          "code": "TESTE000001",
          "quantity": "1"
        },
        {
          "code": "TESTE000002",
          "quantity": "1"
        },
        {
          "code": "TESTE000003",
          "quantity": "1"
        }
      ]
    },
    {
      "id": "84f2cbfc-f3fa-4860-bc6b-b4d42888d7c9",
      "orderCode": "TST-000012",
      "recipient": "Teste",
      "status": "Pedido com a Transpostadora",
      "shippingDate": "2024-12-02",
      "deliveryDate": null,
      "tracking": {
        "trackingId": "05073b28-cf3b-4912-ba55-54d5970a8b78",
        "latitude": 49.67348493629058,
        "longitude": 107.25036531341777,
        "carrier": {
          "code": 4,
          "name": "SP_Interior",
          "zipCodeStart": 12000000,
          "zipCodeEnd": 19999999
        }
      },
      "address": {
        "street": "Teste",
        "number": 123,
        "complement": null,
        "city": "Americana",
        "neighborhood": "Teste",
        "state": "SP",
        "zipCode": 13470160,
        "country": "Brazil",
        "phone": "19991238899"
      },
      "products": [
        {
          "code": "TESTE000001",
          "quantity": "1"
        },
        {
          "code": "TESTE000002",
          "quantity": "1"
        },
        {
          "code": "TESTE000003",
          "quantity": "1"
        }
      ]
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 3,
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalPages": 6,
  "totalElements": 18,
  "first": true,
  "size": 3,
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "numberOfElements": 3,
  "empty": false
}
```

[< Voltar para o índice](../README.md)
