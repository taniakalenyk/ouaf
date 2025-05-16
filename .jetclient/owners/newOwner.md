```toml
name = 'newOwner'
method = 'POST'
url = 'http://localhost:8080/api/owners'
sortWeight = 1000000
id = '69184178-6924-41f5-b69e-7cb9f97d3ad3'

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
