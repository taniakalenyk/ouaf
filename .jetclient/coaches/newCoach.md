```toml
name = 'newCoach'
method = 'POST'
url = 'http://localhost:8080/api/coaches'
sortWeight = 1000000
id = '741957f1-54c1-4a33-9c62-e388b9949964'

[auth]
type = 'NO_AUTH'

[body]
type = 'JSON'
raw = '''
{
  "name": "Maybe",
  "gender": false,
  "birthDate": "2020-08-09",
  "photoId": "max_photo.jpg",
  "weight": 14.5,
  "notes": "Chien habitué aux autres animaux.",
  "enrollments": []
}'''
```
