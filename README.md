# MultiSearch - Backend

API REST Spring Boot do MultiSearch (desafio Full Stack).

Lê os JSONs em `src/main/resources/data`, busca em todas as tabelas, normaliza os resultados e devolve agrupados por categoria.

## Stack

- Java 21
- Spring Boot 3
- Jackson

## Dados

| Arquivo | Tabela |
|---|---|
| `sales_orders.json` | Pedidos de Venda |
| `purchase_orders.json` | Pedidos de Compra |
| `materials.json` | Produtos |
| `equipments.json` | Equipamentos |
| `workforce.json` | Mão de obra |

## Como rodar

1. Use JDK 21
2. Rode `MultisearchApplication`
3. API em `http://localhost:8080`

## Endpoint

```
GET /api/busca?texto=Mesa%20Ret
```
# dev-backend
