```toml
name = 'lessons'
method = 'GET'
url = 'http://localhost:8080/api/lessons'
sortWeight = 2000000
id = '377ee800-43e7-4ab9-88a1-11fa46931c7a'

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
