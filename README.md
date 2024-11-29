# MicroServiço - Gestão de Logistica para Entrega de Pedidos

Micro serviço com a responsabilidade de montar a logistica de entrega de produtos 

- Controle de Envios
- Logistica de seleção de transportadoras / Entregadores

![Visão Macro](docs/assets/macro.png)

## Stack

- Java 17
- Spring Boot 3.3.5

![Workflow](docs/assets/workflow.png)

## Iniciar ambiente dev/local

Inicia containers e configura aplicação. Url de acesso: http://localhost:8084/api/v1

```shell
make dev/local
```
ou
``` shell
docker-compose up -d 
```

## Preparar Banco de Dados

Ao iniciar o projeto será executado um job para carga inicial de transportadoras

> *Atenção:*
>> Para utilização do micro-serviços em ambiente local é necessário a inclusão das transportadoras.
>>
>> Em caso de não execução do JOB inicial executar o seguinte script:
[SqlInsertCarriers](src/main/resources/data.sql)

## Documentação API


##### Admin

- [Login](docs/auth/admin/login.md)
- [Logout](docs/auth/admin/logout.md)
- [Dados usuário](docs/users/current.md)
- [Esqueceu a Senha](docs/auth/admin/forget.md)
- [Reset da Senha](docs/auth/admin/recovery.md)
- [Checar Token](docs/auth/admin/check-token.md)

##### Portal do Cliente

- [Login](docs/auth/panel/login.md)
- [Logout](docs/auth/panel/logout.md)
- [Esqueceu a senha](docs/auth/panel/credentials-forget.md)
- [Listar pedidos ativos para recuperação de login](docs/auth/panel/latest-orders-list.md)
- [Recuperação de credenciais](docs/auth/panel/credentials-recovery.md)
- [Listar pedidos recentes](docs/auth/panel/latest-orders-list.md)

### Lista para preenchimento de Selects

- [Select Options](docs/list-options.md)
- [Relatórios](docs/reports/options.md)

### Usuários

- [Cadastro](docs/users/create.md)
- [Lista](docs/users/list.md)
- [Exibição](docs/users/show.md)
- [Atualização](docs/users/update.md)
- [Exclusão](docs/users/delete.md)
- [Associar Papel](docs/users/role-assign.md)
- [Dessasociar Papel](docs/users/role-unassign.md)
- [Associar permissão](docs/users/permission-assign.md)
- [Dessasociar permissão](docs/users/permission-unassign.md)
- [Listar permissões](docs/users/all-permissions.md)

### Permissiões

- [Cadastro](docs/permissions/create.md)
- [Exibicao](docs/permissions/show.md)
- [Listagem](docs/permissions/list.md)
- [Atualização](docs/permissions/update.md)
- [Exclusão](docs/permissions/delete.md)

### Roles (Papéis)

- [Cadastro](docs/roles/create.md)
- [Exibicao](docs/roles/show.md)
- [Listagem](docs/roles/list.md)
- [Atualização](docs/roles/update.md)
- [Permissões do papel](docs/roles/all-permissions.md)
- [Atribuir permissão ao papel](docs/roles/permission-assign.md)
- [Revogar permissão do papel](docs/roles/permission-unassign.md)

### Clientes

- [Cadastro](docs/customers/create.md)
- [Edição](docs/customers/update.md)
- [Exibicao](docs/customers/show.md)
- [Listagem](docs/customers/list.md)
- [Excluir](docs/customers/delete.md)
- [Histórico de pedidos](docs/customers/history.md)
- [Envio de código PIN para recuperar credenciais](docs/auth/panel/credentials-forget.md)
- [Reenvio da credenciais com confirmação de código PIN](docs/auth/panel/credentials-recovery.md)

### Contatos

- [Listagem](docs/customers/contacts/list.md)
- [Exibicão](docs/customers/contacts/show.md)
- [Atualização](docs/customers/contacts/update.md)
- [Excluir](docs/customers/contacts/delete.md)

### Pedidos

- [Cadastro](docs/orders/create.md)
- [Atualização](docs/orders/update.md)
- [Exibicao](docs/orders/show.md)
- [Listagem](docs/orders/list.md)
- [Excluir](docs/orders/delete.md)
- [Marcar como concluído](docs/orders/close.md)
- [Integração](docs/orders/integration/create.md)
- [Fila de processos](docs/orders/integration/list.md)

### Items do pedido

- [Adicionar item](docs/orders/items/create.md)
- [Exibicao detalhada](docs/orders/items/show.md)
- [Atualizar](docs/orders/items/update.md)
- [Listagem](docs/orders/items/list.md)
- [Excluir](docs/orders/items/delete.md)
- [Upload arquivo de arte](docs/orders/items/upload-workart.md)
- [Upload arquivo de miniatura](docs/orders/items/upload-thumbnails.md)
- [Vincular gabarito](docs/orders/items/jig-assign.md)
- [Desvincular gabarito](docs/orders/items/jig-unassign.md)
- [Marcar como pronto](docs/orders/items/close.md)

### Gabaritos

- [Cadastro](docs/jigs/create.md)
- [Atualização](docs/jigs/update.md)
- [Listagem](docs/jigs/list.md)
- [Exclusão](docs/jigs/delete.md)
- [Upload arquivo](docs/jigs/upload.md)

### Arquivos

- [Download](docs/files/download.md)
- [Aprovar](docs/files/approval.md)
- [Recusar](docs/files/refusal.md)

### Notificações

- [Listagem](docs/notifications/list.md)
- [Marcar como lida](docs/notifications/mark-as-read.md)
- [Marcar como não lida](docs/notifications/mark-as-unread.md)
- [Exclusão](docs/notifications/delete.md)
- [Últimos 15 dias](docs/notifications/list-last-15-days.md)

### Push Notifications (Painel do Cliente)

- [Gabaritos disponíveis](docs/notifications/customer-push/jig-upload.md)
- [Arquivo de Arte Aprovado](docs/notifications/customer-push/workart-approved.md)
- [Arquivo de Arte Recusado](docs/notifications/customer-push/workart-refusal.md)
- [Arquivo de Miniatura de amostra disponível](docs/notifications/customer-push/thumbnail-upload.md)
- [Lembrete de vencimento de tempo limite de upload](docs/notifications/upload-deadline.md)

### Push Notifications (Admin)

- [Arquivo de arte enviado](docs/notifications/admin-push/workart-uploaded.md)
- [Arquivo de miniatura aprovado](docs/notifications/admin-push/thumbnail-refused.md)
- [Arquivo de miniatura recusado](docs/notifications/admin-push/thumbnail-approved.md)
- [Solicitação de aumento de limete para upload](docs/notifications/request-new-upload-size.md)
- Contato do cliente (chat)

### Estoque

- [Modulo de estoque](docs/stock/index.md)

### Relatórios

- [Listagem e consulta](docs/reports/queues/list.md)
- [Tipos de relatórios](docs/reports/options.md)
- [Excluir](docs/reports/queues/delete.md)
- [Download XLS](docs/reports/queues/download.md)

#### Criar relatórios

- [Pedidos pendentes](docs/reports/types/order-warning.md)
- [Pedidos finalizados](docs/reports/types/order-finished.md)
- [Pedidos parados na área de rascunhos](docs/reports/types/order-finished.md)
- [Métricas de estoque](docs/reports/types/stock-metrics.md)

### Integração

- [Cadastrar Usuário](docs/users/integration/create.md)
- [Listar Usuários](docs/users/integration/list.md)

### Logs

- [Auditoria: Lista](docs/logs/audits/list.md)
- [Auditoria: Dias disponíveis para consulta](docs/logs/audits/list-available-days.md)
- [Interações em pedido](docs/logs/activity/activity-logs.md)
- [Interações em pedido: Dias disponíveis para consulta](docs/logs/activity/list-available-days.md)
- [Sistema: Sumário](docs/logs/system/summary.md)
- [Sistema: Diário](docs/logs/system/daily-logs.md)
- [Sistema: Listagem dos items](docs/logs/system/list.md)
- [Sistema: Detalhes Resumo Diário](docs/logs/system/daily-show.md)
- [Sistema: Levels Icons](docs/logs/system/levels.md)
- [Sistema: Delete Daily Log](docs/logs/system/delete-daily.md)
- [Sistema: Delete item Log](docs/logs/system/delete.md)

## PHP Codesniffer

Coding standard PSR12: https://github.com/squizlabs/PHP_CodeSniffer

```shell
make phpcs

make phpcbf
```

http://localhost:8084/swagger-ui/index.html