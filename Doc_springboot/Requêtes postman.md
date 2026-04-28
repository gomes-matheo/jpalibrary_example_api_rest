# REQUESTS (markdown version)

## POST new book

```url
http://localhost:9090/books
```

```json
{
    "available": false,
    "description": "I don't know either",
    "title": "I don't know"
}
```

## POST another new book

```url
http://localhost:9090/books
```

```json
{
    "title": "Hello",
    "description": "world",
    "available": false
}
```

## GET all books

```url
http://localhost:9090/books
```

## GET book by id

```url
http://localhost:9090/books/1
```

## PUT book description

```url
http://localhost:9090/books/2
```

```json
{
    "available": true,
    "description": "world 2",
    "id": 2,
    "title": "Hello"
}
```

## DELETE book by id

```url
http://localhost:9090/books/1
```

## GET books with title

```url
http://localhost:9090/books/search?title=Hello
```
