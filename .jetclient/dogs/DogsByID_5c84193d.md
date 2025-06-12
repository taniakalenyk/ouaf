```toml
name = 'DogsByID'
method = 'GET'
url = 'http://localhost:8080/api/dogs/2'
sortWeight = 3000000
id = '5c84193d-7783-47a0-a561-c549d4a12c26'

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
