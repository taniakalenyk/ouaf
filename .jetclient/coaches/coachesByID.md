```toml
name = 'coachesByID'
method = 'GET'
url = 'http://localhost:8080/api/coaches/5'
sortWeight = 3000000
id = '1a560d2e-556a-4654-a65e-8bff8089046e'

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
