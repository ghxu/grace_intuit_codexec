# grace_intuit_codexec

The project implements both the front and back end, data may be sent via a service call to the backend and stored in a database.
It also implemented with following consideration are implemented:
- Spring boot JPA plus Hebinate 
- Responsive & Mobile Web

Requirement:
Java 1.8+

Backend invoice service:

How to run

./gradlew bootRun

It will run the invoice service at port 8080. And the api entry is /api/invoices.

On the local host, the service is located at http://localhost:8080/api/invoices

How to test

The service comes with a Postman collection (postman_test_collection.json), you could simply import it to Postman.

Frontend html-based invoice implementation is located under resources.


