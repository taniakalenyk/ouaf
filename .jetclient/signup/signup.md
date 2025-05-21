```toml
name = 'signup'
method = 'POST'
url = 'http://localhost:8080/signup'
sortWeight = 1000000
id = 'e283b346-89d1-4762-b971-3e6ed97076ed'

[body]
type = 'JSON'
raw = '''
{
  "firstName": "owner",
  "lastName": "owner",
  "email": "owner@owner.owner",
  "password": "123",
  "role": "OWNER"
}'''
```
