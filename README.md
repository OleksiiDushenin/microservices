# Micro services

Demo micro services application based on Spring Cloud.
All micro services code presented in a single repository 
(each in it's own maven module) in order to simplify deployment, but in
production systems each micro service should have it's own repository 
for separate version management and responsibility separation.

## Architecture

```
                                |               
                                v
                        xxxxxxxxxxxxxxxxx
                        x               x
                        x     Zuul      x------------------------
                        x               x                       |
                        xxxxxxxxxxxxxxxxx                       |
                                |                               |
                                v                               |
                        xxxxxxxxxxxxxxxxx                       |
                        x               x                       |
                        x     Eureka    x-----------------------|
                        x               x                       |
                        xxxxxxxxxxxxxxxxx                       |
                                |                               |
                      ------------------------                  |
                      |                      |                  |
                      v                      v                  |
             xxxxxxxxxxxxxxxxx      xxxxxxxxxxxxxxxxx           |
             x               x      x               x           |
             x     Movies    x ---> xRecommendationsx           |
             x               x      x               x           |
             xxxxxxxxxxxxxxxxx      xxxxxxxxxxxxxxxxx           |
                      |                      |                  |
                      ------------------------------------------|
                                |                               |
                                v                               |
                        xxxxxxxxxxxxxxxxx                       |
                        x               x                       |
                        x Cloud Config  x                       |
                        x               x                       |
                        xxxxxxxxxxxxxxxxx                       |
                                                                |
                                                                |
                                                                |
             ----------------------------------------------------                                                               
            |                   |                       |
            v                   v                       v
 xxxxxxxxxxxxxxxxx      xxxxxxxxxxxxxxxxx     xxxxxxxxxxxxxxxxx
 x               x      x               x     x               x
 x     Sleuth    x      x   Zipkin      x     x  Pappertrail  x
 x               x      x               x     x               x
 xxxxxxxxxxxxxxxxx      xxxxxxxxxxxxxxxxx     xxxxxxxxxxxxxxxxx




```

## Technology stack

- `Spring Boot`
- `Spring Cloud. Zuul`
- `Spring Cloud. Eureka`
- `Spring Cloud. Hystrix`
- `Spring Cloud. Ribbon`
- `Spring Cloud. Config Server`
- `Spring Cloud. Sleuth`
- `Zipkin`
- `Pappertrail`
- `Docker`
- `Maven`
- `Travis CI`

## Build procedure

### Run application

#### Required tools

In order to run application next tools should be installed on your 
local machine:
- `docker`

#### Deployment procedure
- Run `run.sh` file

### Test purposes

#### Required tools

In order to run application next tools should be installed on your 
local machine:
- `docker`
- `maven`

#### Deployment procedure
- Run `microservices.sh` file

### Endpoints

`Movies`:

```shell
curl http://localhost:5555/api/moviesservice/movies/1

{"id":1,"name":"Name 1","country":"US","year":1991,"description":"Description 1"}

```

`Recommendations`:

```shell
curl http://localhost:5555/api/moviesservice/movies/1/recommendations

[{"id":4,"name":"Name 4","country":"US","year":1994,"description":"Description 4"},{"id":5,"name":"Name 5","country":"US","year":1995,"description":"Description 5"},{"id":7,"name":"Name 7","country":"US","year":1997,"description":"Description 7"},{"id":8,"name":"Name 8","country":"US","year":1998,"description":"Description 8"},{"id":9,"name":"Name 9","country":"US","year":1999,"description":"Description 9"}]

```
