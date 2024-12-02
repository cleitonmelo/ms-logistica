### Finaliza a Entrega do pedido

Efetuar a finalização da entrega do pedido, processo responsável por preencher a data de entrega e alterar o status do pedido para entregue.

- **Método:** `PUT`
- **Ponto de acesso:** `api/v1/shippings/finished/{id}`
- **Código HTTP:** `204 NO CONTENT`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8084/api/v1/shippings/finished/dc8cc00c-fce1-4d85-be7c-7c5632352f56'
```
    GET  api/v1/shippings/finished/{id}

[< Voltar para o índice](../README.md)
