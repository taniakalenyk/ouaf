```toml
name = 'login'
method = 'POST'
url = 'http://localhost:8080/login'
sortWeight = 1000000
id = '3cb43a71-c679-4c49-86e6-7148dcd6cb5f'

[auth]
type = 'BEARER'

[body]
type = 'JSON'
raw = '''
{
  "email": "owner@ouaf.academy",
  "password": "12345"
}'''
```
