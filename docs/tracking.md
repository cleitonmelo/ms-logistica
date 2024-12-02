### Listar / Pequisar pelo código do Rastreio 

Permiti listar todos os rastreios e pesquisar pelo código de rastreio alterado

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/trackings`
- **Código HTTP:** `200 OK`

#### Parâmetro
| **Campo**  | **Tipo**    | **Descrição**      | **Requerido** | **Enum**                    | 
|------------|-------------|--------------------|---------------|-----------------------------|
| trackingId | String      | Código do Rastreio | Não            |                             |

```shell
curl --location 'http://localhost:8084/api/v1/trackings?size=5'
```
OU
```shell
curl --location 'http://localhost:8084/api/v1/trackings/0813571b-001d-4baa-b7db-dc8758d88114'
```
    GET  api/v1/trackings/{id}

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
    "trackingId": "0813571b-001d-4baa-b7db-dc8758d88114",
    "latitude": -79.76886537303861,
    "longitude": -97.56009078768177,
    "carrier": {
        "code": 18,
        "name": "Recife",
        "zipCodeStart": 50000000,
        "zipCodeEnd": 52999999
    }
}
```

[< Voltar para o índice](../README.md)
