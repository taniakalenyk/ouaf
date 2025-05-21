```toml
name = 'dogs'
method = 'GET'
url = 'http://localhost:8080/api/dogs'
sortWeight = 2000000
id = '1fa25f5b-af1e-4d42-a7c9-63921db06b53'

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
