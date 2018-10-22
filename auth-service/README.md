## Get token
### localhost
curl -X POST --user "auth:auth" -d "grant_type=password&username=peter@example.com&password=password" http://localhost:9002/authserver/oauth/token

## Commands examples (Chrome console)

## GET TOKEN

fetch('/authserver/oauth/token', {
  method: 'POST',
  headers: new Headers({
    'Authorization': 'Basic ' + btoa('auth:auth'),
    'Content-Type': 'application/x-www-form-urlencoded'
  }),
  body: 'grant_type=password&username=peter@example.com&password=password'
})
.then(r => r.json())
.then(r => console.log(r))