### Criar um envio de Pedido

Recebe os dados para criação de um envio para o Pedido

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/shippings`
- **Código HTTP:** `200 OK`

#### Parâmetro

| **Campo** | **Tipo**    | **Descrição**      | **Requerido** | **Enum**                    | 
|-----------|-------------|--------------------|---------------|-----------------------------|
| orderCode | String      | Código do Pedido   | Sim           |                             |
| recipient | String      | Nome do Recebedor  | Sim           |                             |
| address   | Object      | Dados do Endereço  | Sim           |                             |
| products  | List Object | Dados dos Produtos | Sim           |                             |

#### Parâmetros Address

| **Campo**    | **Tipo** | **Descrição** | **Requerido** | **Enum**                    | 
|--------------|----------|---------------|---------------|-----------------------------|
| street       | String   | Rua           | Sim           |                             |
| number       | Number   | Numero        | Sim           |                             |
| complement   | String   | Complemento   | Não           |                             |
| neighborhood | String   | Bairro        | Sim           |                             |
| city         | String   | Cidade        | Sim           |                             |
| state        | String   | Estado        | Sim           |                             |
| zipCode      | Number   | CEP           | Sim           |                             |
| country      | String   | Pais          | Não           |                             |
| phone        | String   | Telefone      | Não           |                             |


#### Parâmetros Products

| **Campo**    | **Tipo** | **Descrição**         | **Requerido** | **Enum**                    | 
|--------------|----------|-----------------------|---------------|-----------------------------|
| code         | String   | Código do Produto     | Sim           |                             |
| quantity     | Number   | Quantidade do Produto | Sim           |                             |


```shell
curl --location 'http://localhost:8084/api/v1/shippings' \
--header 'Content-Type: application/json' \
--data '{
    "orderCode": "AXS000910",
    "recipient": "Outras Regiões",
    "address": {
        "street": "Rua Gonçalves Nina",
        "number": 168,
        "complement": null,
        "neighborhood" : "Parque das Nações",
        "city": "Americana",
        "state": "SP",
        "zipCode": 51310190,
        "country": "Brazil",
        "phone" : "11982259121"
    },
    "products": [
        {
            "code": "PRODUTO 00001",
            "quantity": 1
        },
        {
            "code": "PRODUTO 00002",
            "quantity": 1
        },
        {
            "code": "PRODUTO 00003",
            "quantity": 1
        },
        {
            "code": "PRODUTO 00004",
            "quantity": 1
        }
    ]
}'
```
    POST  api/v1/shippings

#### Exemplo de resposta de sucesso

```json
{
  "id": "839cd32c-f9f8-404c-b17d-db2a0c8ef5ca",
  "orderCode": "AXS000910",
  "recipient": "Outras Regiões",
  "status": "Pedido Recebido",
  "shippingDate": null,
  "deliveryDate": null,
  "tracking": null,
  "address": {
    "street": "Rua Gonçalves Nina",
    "number": 168,
    "complement": null,
    "city": "Americana",
    "neighborhood": "Parque das Nações",
    "state": "SP",
    "zipCode": 51310190,
    "country": "Brazil",
    "phone": "11982259121"
  },
  "products": [
    {
      "code": "PRODUTO 00001",
      "quantity": "1"
    },
    {
      "code": "PRODUTO 00002",
      "quantity": "1"
    },
    {
      "code": "PRODUTO 00003",
      "quantity": "1"
    },
    {
      "code": "PRODUTO 00004",
      "quantity": "1"
    }
  ]
}
```

[< Voltar para o índice](../README.md)
