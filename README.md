# MultiSearch - Backend

API REST em Spring Boot para busca nos dados do ERP.

## Como rodar

1. Use **JDK 21** no projeto
2. Rode `MultisearchApplication` no IntelliJ
3. A API sobe em `http://localhost:8080`

## Endpoint

```
GET /api/busca?texto=Mesa%20Ret
```

Resposta agrupada por categoria: pedidos de venda, pedidos de compra, produtos, equipamentos e mão de obra.
