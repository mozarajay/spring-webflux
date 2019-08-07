## Reactive Microservices with Spring WebFlux

We have two microservices order-service, customer-service that use MongoDB as a database. Microservice customer-service calls endpoint GET /customer/{customer} exposed by order-service. URL of order-service is taken from Eureka. The whole sample system is hidden behind gateway, which is available under address localhost:8090.
To test inter-service communication just call endpoint GET /customer/{id}/with-orders on gateway-service. It forward the request to customer-service, and then customer-service calls enpoint exposed by order-service using reactive WebClient
