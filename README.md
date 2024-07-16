# SISTEMA DE PEDIDOS PARA EMPRESA KELPRINT

## Diagrama de Classes:

```mermaid
classDiagram
    class Client {
        int id
        String name
        Date creationTimestamp
        Date updateTimestamp
    }

    class Order {
        int id
        String orderDescription
        int amount
        String sizes
        String kindOfFabric
        String typeOfCollar
        String comments
        Date creationTimestamp
        Date deliveryDate
        boolean finished
    }

    Client "1" --> "0..*" Order
```
