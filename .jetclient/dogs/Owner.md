```toml
name = 'Owner'
method = 'POST'
url = 'http://localhost:8080/api/owners'
sortWeight = 1000000
id = 'c74af154-1a42-489a-908a-29cebe8aed2f'

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
