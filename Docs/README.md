# Spring Boot Market API


### Properties

---

* Get Product Comments By Id 
* Get Product Comment By Date Range
* Get Customer Comments
* Get Customer Comments By Date Range
* Get Expired Products
* Get Not Expired Products

<br>


### Models

---


<img src="../Docs/Schema.jpg" alt="drawing" width="500"/>

<br>
<br>

### Tech Stack

----

* Java 17
* Spring Boot 2.7.3
* Spring Data JPA
* JUnit 5 - Unit and Integration Tests
* H2 Database
* Docker
* OpenAPI Documentation

<br>

#### Build & Run ( Docker )

---


```shell
docker build . -t marketapi:1.0
docker run --name MarketAPI -d -p 8080:8080 marketapi:1.0
```

<br>

#### Swagger UI

----

```
http://localhost:8080/swagger-ui/index.html
```

<br>

#### Postman

---

[Postman Collection for Test => Import to Postman](MarketAPI.postman_collection.json "download")


<br>
<br>