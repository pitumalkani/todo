# todo
### GET http://localhost:8080/todo
```
[
    {
        "id": "8b633526-da2a-47da-ac19-f13eb672e4ec",
        "name": "Buy new book Java Revisited",
        "createdDate": "2021-11-29T13:41:38.713+00:00",
        "done": true
    },
    {
        "id": "dc196c2d-4615-4f5e-9405-2b9c72d4bfb3",
        "name": "Buy new cycle",
        "createdDate": "2021-11-29T13:41:38.713+00:00",
        "done": false
    },
    {
        "id": "4142323c-ae13-4b21-bb5e-5dee73ec5f19",
        "name": "Buy new tennis bat",
        "createdDate": "2021-11-29T13:41:38.713+00:00",
        "done": false
    },
    {
        "id": "8d4c1f8a-326c-408a-9937-25102af0e7b0",
        "name": "Buy new camera",
        "createdDate": "2021-11-29T13:41:38.713+00:00",
        "done": false
    }
]
```
## GET GET http://localhost:8080/todo/{todoId}
```
{
    "id": "8e2afbd4-71f6-48df-94b8-670de79c808e",
    "name": "Buy new book Java Revisited",
    "createdDate": "2021-11-30T13:28:51.222+00:00",
    "done": true
}
```


### POST http://localhost:8080/todo
```
{
    "name": "Learn Driving"
}
```

### PUT http://localhost:8080/todo/{todoId}
```
{
    
    "name": "Buy new book Java Revisited",
    "done": true
}
```

### DELETE http://localhost:8080/todo/{todoId}
