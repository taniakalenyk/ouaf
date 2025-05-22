```toml
name = 'newCoach'
method = 'PUT'
url = 'http://localhost:8080/api/coaches/4'
sortWeight = 1000000
id = '741957f1-54c1-4a33-9c62-e388b9949964'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBvdWFmLmFjYWRlbXkiLCJpZCI6MSwicm9sZSI6IlJPTEVfQURNSU4iLCJleHAiOjE3NDc5MTk5NDN9.nYpf-x_2i6AfxSLRuqKxBE1wMEmLk8BRWi-TV8uNRj8'

[body]
type = 'JSON'
raw = '''
{
  "userId": 4,
  "firstName": "Jean",
  "lastName": "MAAAAARTIIIN",
  "email": "coachiam@ouaf.academy",
  "password": "12345",
  "photoId": null,
  "registrationDate": "2025-05-22T12:20:00.083859",
  "verificationEmailToken": null,
  "role": null,
  "phoneNumber": "989115998",
  "type": null
}'''
```
