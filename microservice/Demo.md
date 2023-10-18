Add Items:

```
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Great Pen", "score" :5, "productId": 1}'
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Ok Blue Pen", "score" :4, "productId": 1}'
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Great Silver Pen", "score" :5, "productId": 2}'
curl -X POST http://localhost:8081/reviews -H "Content-Type: application/json" -d '{"review" : "Cool Pen", "score" :5, "productId": 3}'
```

Get Reviews
curl -X GET http://localhost:8081/reviews -H "Content-Type: application/json"

Get Specific Review
curl -X GET http://localhost:8081/reviews/2 -H "Content-Type: application/json"

Update review
curl -X PUT http://localhost:8081/reviews/2 -H "Content-Type: application/json" -d '{"review" : "It is better than I thought! ", "score" :5, "productId": 1}'

curl -X DELETE http://localhost:8081/reviews/2 -H "Content-Type: application/json"
