#bin/bash

curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Great Pen", "score" :5, "productId": 1}'
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Ok Blue Pen", "score" :4, "productId": 1}'
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Great Silver Pen", "score" :5, "productId": 2}'
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "I hate this Pen", "score" :1, "productId": 2}'