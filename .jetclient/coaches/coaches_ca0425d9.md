```toml
name = 'coaches'
method = 'GET'
url = 'http://localhost:8080/api/coaches'
sortWeight = 2000000
id = 'ca0425d9-8c22-4c68-9b3b-8bd5d1c4b37e'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBvdWFmLmFjYWRlbXkiLCJyb2xlIjoiUk9MRV9BRE1JTiIsImV4cCI6MTc0Nzg2ODA5N30.d1Nf9JUO1ZGBPEDW68WhzH5qSiiciRkHM4mD6zfB-84'

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
