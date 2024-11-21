# SpringES
# Spring Boot Elasticsearch Product API

This project is a Spring Boot application that uses Elasticsearch for full-text search. It provides a RESTful API to manage and query product data.

### Prerequisites
- Java 17 or higher
- Maven
- Docker (for running Elasticsearch)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/username/repo-name.git
   cd repo-name

2. Pull and run Elasticsearch container
   ```bash
   docker pull docker.elastic.co/elasticsearch/elasticsearch:7.17.9
   docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "xpack.security.enabled=false" -m 4g --name my_elasticsearch_container docker.elastic.co/elasticsearch/elasticsearch:7.17.

3. Check Elasticsearch container is running
   ```bash
   docker ps -a

4. Build the project
   ```bash
    mvn clean install

5. Run the application
   ```bash
    mvn SpringES:run

API examples runs on http://localhost:8082

1. Get all products
   ```bash
   GET /apis/products

2. Add new products
   ```bash
   POST /apis/insert
   Request Body:
   {
   "id": 1001,
   "pName": "Air India",
   "category": "Airline"
   "qty": 10,
   "price": 9000
   },
   {
   "id": 1002,
   "pname": "DEll Inspiron",
   "category": "Laptop",
   "qty": 30,
   "price": 299899.0
   },
   {
   "id": 1003,
   "pname": "DEll Inspiron",
   "category": "Laptop volume",
   "qty": 3,
   "price": 299899.0
   }

3. Search product by name
   ```bash
   GET /apis/search?pname=DE

4. Search product by category
   ```bash
   GET /apis/products/search?category=Laptop
   
5. Search product by name by POST API
   ```bash
   POST /apis/products/_search
   {
    "field": "pname",
    "value": "Ford"
   }
   
6. Search product by name with filter by price less than or equal
   ```bash
   POST /apis/products/_advance_search
   {
    "field": "pname",
    "value": "Ford",
    "priceLte": 5000
   }

7. Search product by name without filter
   ```bash
   {
   "field": "pname",
   "value": "Ford"
   }
   


## **API Endpoints**
list of the API endpoints with their methods, paths, descriptions, and examples.

Example:
| Method | Endpoint                          | Description                                | Example                  |
|--------|-----------------------------------|--------------------------------------------|--------------------------|
| GET    | `/apis/products`                  | Retrieve all products                      | `curl -X GET http://localhost:8082/apis/products` |
| POST   | `/apis/insert`                    | Insert a new product                       | `curl -X POST -d '{"id":1,"pName":"Laptop","qty":10,"price":999.99}' -H 'Content-Type: application/json' http://localhost:8082/apis/insert` |
| GET    | `/apis/search`                    | Search product by name                     | `curl -X GET 'http://localhost:8082/apis/search?pname=Laptop'` |
| GET    | `/apis/search`                    | Search product by category                 | `curl -X GET 'http://localhost:8082/apis/products/search?category=Airline'` |
| POST   | `/apis/products/_search`          | Search product by name                     | `curl -X POST -d '{"field":"pName","value":"Ford"}' -H 'Content-Type: application/json' http://localhost:8082/apis/products/_search` |
| POST   | `/apis/products/_advance_search`  | Search by name by filter by price          | `curl -X POST -d '{"field":"pName","value":"Ford","priceLte": 5000}' -H 'Content-Type: application/json' http://localhost:8082/apis/products/_advance_search` |




