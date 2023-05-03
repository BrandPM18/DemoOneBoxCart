# Challenge Test Onebox
 by [Brando Palacios](https://www.linkedin.com/in/brando-palacios-842b53162?fbclid=IwAR3HC8xbg8Q2_R4idKT9cIaX3edtjJH6W_BRtqUECKnK_J7ORodG4f2aYIk)

# Description Project

The service is presented using a variant of the MVC architecture applying different tools that allow easy testing of the challenge. For this we use an in-memory H2 database and documentation using Swagger. We opted for the use of Java 17 as a test implementation.

# Getting Started

### Reference Dependencies

We used java version 17 using the following dependencies:

* Spring Boot 3.0.4
* Apache Maven 3.8.7
* H2 Database
* MyBatis 
* Lombok 
* Swagger

### How to run the project

1. Clone the repository
2. Build the project with mvn command: `mvn clean install`
3. Run the project with mvn command: `mvn spring-boot:run`
4. You can test the endpoints using the swagger interface go to the following url: http://localhost:8080/swagger-ui/index.html#/

### How to run the tests
* Run the tests with mvn command: `mvn test`

## Endpoints

### Cart Controller

Cart is an online shopping cart concept commonly used in ecommerce services, in which we store our list of desired products, therefore we use the following endpoints to manipulate the cart.

<details>
 <summary><code>GET</code> <code><b>/cart </b></code> <code>(Get all carts)</code></summary>
<br>
Get all active carts in list

##### Parameters

> None

##### Responses
```json
{
  "carts": [
    {
      "id": "3c11c6f4-b7cf-4feb-88ab-50f9b196f679",
      "totalPrice": 34.3,
      "productListIds": [
        1
      ],
      "creationUser": "bpalaciosm",
      "modificationUser": "bpalaciosm",
      "creationDate": "2023-05-03T07:08:25.909531",
      "modificationDate": "2023-05-03T07:08:25.909531"
    }
  ]
}
```

##### Example cURL

```javascript
curl -X 'GET' \
  'http://localhost:8080/cart' \
  -H 'accept: application/hal+json'
```
</details>



<details>
 <summary><code>POST</code> <code><b>/cart</b></code> <code>(Create new shopping cart)</code></summary>
<br>
Create a new cart with a list of products. These products must already exist in the database.

##### Parameters

> None

##### Request Body

```json
{
  "productListIds": [
    1
  ],
  "creationUser": "onebox"
}
```

##### Responses (`200`)
```json
{
  "id": "308e0332-7c16-4ed8-9570-e8ed9517dc49"
}
```


##### Example cURL

```javascript
curl -X 'POST' \
  'http://localhost:8080/cart' \
  -H 'accept: application/hal+json' \
  -H 'Content-Type: application/json' \
  -d '{
  "productListIds": [
    1
  ],
  "creationUser": "onebox"
}'
```
</details>



<details>
 <summary><code>GET</code> <code><b>/cart/{id} </b></code> <code>(Get cart information)</code></summary>
<br>
Get cart information by generated id

##### Parameters

* id : `String` [Example: `3c11c6f4-b7cf-4feb-88ab-50f9b196f679`]

##### Responses
```json
{
  "id": "3c11c6f4-b7cf-4feb-88ab-50f9b196f679",
  "totalPrice": 34.3,
  "productListIds": [
    1
  ],
  "creationUser": "bpalaciosm",
  "modificationUser": "bpalaciosm",
  "creationDate": "2023-05-03T07:08:25.909531",
  "modificationDate": "2023-05-03T07:08:25.909531"
}
```

##### Example cURL

```javascript
curl -X 'GET' \
  'http://localhost:8080/cart/3c11c6f4-b7cf-4feb-88ab-50f9b196f679' \
  -H 'accept: application/hal+json'
```
</details>




<details>
 <summary><code>PUT</code> <code><b>/cart/{id} </b></code> <code>(Put or Drop products from cart)</code></summary>
<br>
Enpoint in charge of removing or putting products in the cart and updating to the latest modification. 
For this we use the flag addToCart that will indicate if it is placing or removing products. During this process the cart will be updated with the total price.

##### Parameters


* id : `String` [Example: `3c11c6f4-b7cf-4feb-88ab-50f9b196f679`]

#### Case 1 (`Drop Product`):

##### Request Body

```json
{
  "productListIds": [
    1
  ],
  "addToCart": false,
  "modificationUser": "user"
}
```

##### Responses (`200`)
```json
{}
```


#### Case 2 (`Add Product`):

##### Request Body

```json
{
  "productListIds": [
    1
  ],
  "addToCart": true,
  "modificationUser": "user"
}
```

##### Responses (`200`)
```json
{}
```

##### Example cURL

```javascript
curl -X 'PUT' \
  'http://localhost:8080/cart/3c11c6f4-b7cf-4feb-88ab-50f9b196f679' \
  -H 'accept: application/hal+json' \
  -H 'Content-Type: application/json' \
  -d '{
  "productListIds": [
    1
  ],
  "addToCart": false,
  "modificationUser": "user"
}'
```
</details>

<details>
 <summary><code>DELETE</code> <code><b>/cart/{id} </b></code> <code>(Get cart information)</code></summary>
<br>
Delete cart by id

##### Parameters

* id : `String` [Example: `3c11c6f4-b7cf-4feb-88ab-50f9b196f679`]

##### Responses (`200`)
```json
{}
```

##### Example cURL

```javascript
curl -X 'DELETE' \
  'http://localhost:8080/cart/3c11c6f4-b7cf-4feb-88ab-50f9b196f679' \
  -H 'accept: application/hal+json'
```
</details>

### Product Controller

Every cart has products for purchase, these products are listed and well labeled according to the catalog that has our platform.

<details>
 <summary><code>GET</code> <code><b>/product </b></code> <code>(Get all products)</code></summary>
<br>
Get all list of products in database

##### Parameters

> None

##### Responses
```json
{
  "products": [
    {
      "id": 1,
      "description": "Product 1",
      "price": 1
    }
  ]
}
```

##### Example cURL

```javascript
curl -X 'GET' \
  'http://localhost:8080/product' \
  -H 'accept: application/hal+json'
```
</details>



<details>
 <summary><code>POST</code> <code><b>/product/{id}</b></code> <code>(Create new product)</code></summary>
<br>
Create new product in database

##### Parameters

> None

##### Request Body

```json
{
  "description": "Product 2",
  "price": 10.3
}
```

##### Responses
```json
{
  "id": 2
}
```

##### Example cURL

```javascript
curl -X 'POST' \
  'http://localhost:8080/product' \
  -H 'accept: application/hal+json' \
  -H 'Content-Type: application/json' \
  -d '{
  "description": "Product 2",
  "price": 10.3
}'
```
</details>




<details>
 <summary><code>GET</code> <code><b>/product/{id}</b></code> <code>(Get product information)</code></summary>
<br>
View specific product

##### Parameters

* id : `String` [Example: `3c11c6f4-b7cf-4feb-88ab-50f9b196f679`]

##### Responses
```json
{
  "id": 1,
  "description": "Product 1",
  "price": 1
}
```

##### Example cURL

```javascript
curl -X 'GET' \
  'http://localhost:8080/product/1' \
  -H 'accept: application/hal+json'
```
</details>


## Screeshot Evidence

### SwaggerUI
OpenAPIv3 was used to launch our documentation.
<br>
<p align="center">
  <img src="https://github.com/BrandPM18/DemoOneBoxCart/blob/main/dist/swaggerUI.png" alt="Dont"/>
</p>

## Scheduling Task
A task is set every 10 minutes to check that no car has expired, otherwise it deletes it. This can be found in the `JobConfiguration.java` file.
<br>
<p align="center">
  <img src="https://github.com/BrandPM18/DemoOneBoxCart/blob/main/dist/scheduleTask.png" alt="Give"/>
</p>

### Test Success
Nine tests were performed and were satisfactory.
<br>
<p align="center">
  <img src="https://github.com/BrandPM18/DemoOneBoxCart/blob/main/dist/test.png" alt="Up"/>
</p>
