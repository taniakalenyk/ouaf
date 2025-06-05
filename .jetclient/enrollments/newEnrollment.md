```toml
name = 'newEnrollment'
method = 'GET'
url = 'http://localhost:8080/api/dogs/3'
sortWeight = 1000000
id = '7d4933f8-6003-4a1d-a105-cbaa07dbb7ee'

[auth]
type = 'NO_AUTH'

[body]
type = 'JSON'
raw = '''
{
  "name": "Bella",
  "gender": true,
  "birthDate": "2022-04-15",
  "photoId": "bella_photo.jpg",
  "weight": 8.2,
  "notes": "Chienne vive, adore jouer avec les enfants.",
  "primaryBreed": {
    "breedId": 2,
    "breedName": "Labrador Retriever"
  },
  "secondaryBreed": null,
  "veterinarian": null,
  "owner": {
    "userId": 2
  }
}'''
```
