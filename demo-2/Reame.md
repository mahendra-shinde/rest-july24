## Test with `curl`

### Test the find-all method
curl -H "Accept: application/json" http://localhost:8080/api/department      

### Test the find by deptno method
curl -H "Accept: application/json" http://localhost:8080/api/department/find?deptno=d009     

### Test the POST method (create)
curl -vX POST -H "Content-Type: application/json" http://localhost:8080/api/department -d "{\"deptNo\":\"d109\",\"name\":\"House Keeping\"}" 

### Test the newly created record
curl -H "Accept: application/json" http://localhost:8080/api/department/find?deptno=d109           

### Test Patch method on existing record
curl -X PATCH -H "Accept: application/json" http://localhost:8080/api/department?deptno=d109&newname=Max


