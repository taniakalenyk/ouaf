```toml
name = 'ownersByID'
method = 'GET'
url = 'http://localhost:8080/api/owners/3'
sortWeight = 3000000
id = 'c62d3077-af8f-4400-ac40-0e5a5bc96596'

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
