```toml
name = 'OwnersByID'
method = 'GET'
url = 'http://localhost:8080/api/owners/3'
sortWeight = 3000000
id = '5c84193d-7783-47a0-a561-c549d4a12c26'

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
