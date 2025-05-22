```toml
name = 'coachesByID'
method = 'GET'
url = 'http://localhost:8080/api/coaches/4'
sortWeight = 3000000
id = '1a560d2e-556a-4654-a65e-8bff8089046e'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBvdWFmLmFjYWRlbXkiLCJyb2xlIjoiUk9MRV9BRE1JTiIsImV4cCI6MTc0Nzg2OTcxNX0.PUeEvSSp250t5Y5LJiAdICzypztMnH_7bEIAygWEh6w'

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
