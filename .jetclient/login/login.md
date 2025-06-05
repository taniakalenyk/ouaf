```toml
name = 'login'
method = 'POST'
url = 'http://localhost:8080/login'
sortWeight = 1000000
id = '3cb43a71-c679-4c49-86e6-7148dcd6cb5f'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBvdWFmLmFjYWRlbXkiLCJyb2xlIjoiUk9MRV9BRE1JTiIsImV4cCI6MTc0Nzg2ODA5N30.d1Nf9JUO1ZGBPEDW68WhzH5qSiiciRkHM4mD6zfB-84'

[body]
type = 'JSON'
raw = '''
{
  "email": "owner@ouaf.academy",
  "password": "12345"
}'''
```
