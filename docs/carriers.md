### Listar as Transportadoras

Listar as Transportadoras

- **Método:** `GET`
- **Ponto de acesso:** `api/v1/carriers`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location 'http://localhost:8084/api/v1/carriers?size=5'
```
    GET  api/v1/carriers

#### Exemplo de resposta de sucesso

```json
{
  "content": [
    {
      "code": 1,
      "name": "SP CAPITAL",
      "zipCodeStart": 1000000,
      "zipCodeEnd": 5999999
    },
    {
      "code": 2,
      "name": "SP_Área_Metropolitana",
      "zipCodeStart": 6000000,
      "zipCodeEnd": 9999999
    },
    {
      "code": 3,
      "name": "SP_Litoral",
      "zipCodeStart": 11000000,
      "zipCodeEnd": 11999999
    },
    {
      "code": 4,
      "name": "SP_Interior",
      "zipCodeStart": 12000000,
      "zipCodeEnd": 19999999
    },
    {
      "code": 5,
      "name": "RJ_Capital",
      "zipCodeStart": 20000000,
      "zipCodeEnd": 23799999
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 5,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": false,
  "totalPages": 14,
  "totalElements": 66,
  "first": true,
  "size": 5,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "numberOfElements": 5,
  "empty": false
}
```

[< Voltar para o índice](../README.md)
