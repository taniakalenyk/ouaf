```toml
name = 'ownersByID'
method = 'GET'
url = 'http://localhost:8080/api/owners/3'
sortWeight = 3000000
id = '6582180d-4ee3-4087-bbb4-da3ad29de4d5'

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
