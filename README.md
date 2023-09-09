# coronavirus-daily-report

**Kotlin/Spring** web service I created for my own usage to send daily reports about COVID19.
<br>
<br>
**Subscribers** will daily get a report about COVID19 includes some interesting data and statistics.
<br><br>
Actually it's archived.

## Functionality
* Send daily emails with report about COVID19.
* Allows to subscribe and unsubscribe
* Requires email verification
* Using thymeleaf to generate mails.

## In report you will see...
* **New Deaths**
* **Positive Covid** tests compared to negative tests
* **Confirmed Cases** compared to total

## Usage
```shell
# To subscribe 
PUT /subscribe/{email}
# OK: 201

# To confirm email
POST /subscribe/{email}/code={code}
# OK: 204

# To unsubscribe
DELETE /subscription/{email}/cancel/{cancelCode}
# OK: 204
```

## Installation

```shell
# clone the repo
git clone https://www.github.com/kacperfaber/coronavirus-daily-report && cd coronavirus-daily-report
```

Initialize the repo
```shell
mvn install
```

## Run locally
```shell
# run locally as developer
mvn spring-boot:run -Dspring.profiles.active=dev
```

## Configuration
#### Configure database using
`src/main/resources/dev.hiberante.cfg.xml`

## Author
Kacper Faber