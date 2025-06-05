```toml
name = 'lessonsByID'
method = 'GET'
url = 'http://localhost:8080/api/dogs/1'
sortWeight = 3000000
id = '780e7d3f-5743-4a09-b246-aaebd32c16d8'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvd25lckBvdWFmLmFjYWRlbXkiLCJyb2xlIjoiUk9MRV9PV05FUiIsImlkIjozfQ.tTJQsWMdn4JND76zNKk3UG-SfCFt46Oe-j4jezjwzjM'

[body]
type = 'JSON'
raw = '''
{
  "firstName": "Tetiana",
  "lastName": "Lombardi",
  "email": "taniak@example.com",
  "password": "Testuu321",
  "phoneNumber": "0782442874",
  "photoId": "adminphoto1.jpg"
}'''
```
