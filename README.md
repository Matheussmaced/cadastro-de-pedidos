# SISTEMA DE PEDIDOS PARA EMPRESA KELPRINT

## Diagrama de Classes:

```mermaid
classDiagram
    class User {
        int id
        String name
        String creationTimestamp
        String updateTimestamp
    }

    class Order {
        int id
        String orderDescription
        int amount
        String sizes
        String kindOfFabric
        String typeOfCollar
        String comments
        String creationTimestamp
        String deliveryDate
        boolean finished
    }

    User "1" --> "0..*" Order
```
