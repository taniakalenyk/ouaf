```toml
name = 'newOwner'
method = 'POST'
url = 'http://localhost:8080/api/owners'
sortWeight = 1000000
id = 'a578812f-cff8-4fa0-bba2-2ad52b2f755d'

[auth]
type = 'NO_AUTH'

[body]
type = 'JSON'
raw = '''
{
  "firstName": "Tetiana",
  "lastName": "Lombardi",
  "email": "tk@example.com",
  "password": "Test321",
  
}'''
```
