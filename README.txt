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
    docker pull docker.elastic.co/elasticsearch/elasticsearch:7.17.9
    docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "xpack.security.enabled=false" -m 4g --name my_elasticsearch_container docker.elastic.co/elasticsearch/elasticsearch:7.17.

    2.a Check Elasticsearch container is running
        docker ps -a

3.Build the project
    mvn clean install

4.Run the application
    mvn SpringES:run

API runs on http://localhost:8082

1. Get all products
    GET /apis/products

2. Add new products
    POST /apis/insert
    Request Body:
    {
        "id": 1,
        "pName": "Laptop",
        "qty": 10,
        "price": 999.99
    }

3. Search product by name
    GET /apis/search?pname=Smartphone


## **API Endpoints**
list of the API endpoints with their methods, paths, descriptions, and examples.

Example:
| Method | Endpoint       | Description              | Example                  |
|--------|----------------|--------------------------|--------------------------|
| GET    | `/apis/products` | Retrieve all products   | `curl -X GET http://localhost:8082/apis/products` |
| POST   | `/apis/insert`   | Insert a new product    | `curl -X POST -d '{"id":1,"pName":"Laptop","qty":10,"price":999.99}' -H 'Content-Type: application/json' http://localhost:8082/apis/insert` |
| GET    | `/apis/search`   | Search product by name  | `curl -X GET 'http://localhost:8082/apis/search?pname=Laptop'` |




