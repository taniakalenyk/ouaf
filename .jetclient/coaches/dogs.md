```toml
name = 'dogs'
method = 'GET'
url = 'http://localhost:8080/api/dogs'
sortWeight = 2000000
id = 'ca0425d9-8c22-4c68-9b3b-8bd5d1c4b37e'

[auth]
type = 'NO_AUTH'

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
