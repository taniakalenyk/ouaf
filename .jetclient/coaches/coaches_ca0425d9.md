```toml
name = 'coaches'
method = 'GET'
url = 'http://localhost:8080/api/owner/3'
sortWeight = 2000000
id = 'ca0425d9-8c22-4c68-9b3b-8bd5d1c4b37e'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvd25lckBvdWFmLmFjYWRlbXkiLCJpZCI6Mywicm9sZSI6IlJPTEVfT1dORVIifQ.eCY4E49_ypEa_XvMipHyyX-gSN25XDcHeWbuFAgvvyQ'

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
