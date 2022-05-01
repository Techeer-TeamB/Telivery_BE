# Telivery_BE
배달 서비스 클론 코딩 백엔드 Repository (Spring-Boot)

## 디렉토리 구조

### /api
> Controller, Config을 관리
### /application
> Service, dto 관련 비즈니스 로직을 관리
### /domain
> Entity, Repository을 관리

```bash
.
├── README.md
├── api
│   ├── build.gradle
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── telivery
│       │   │           ├── TeliveryApiApplication.java
│       │   │           ├── configuration
│       │   │           │   └── SwaggerConfig.java
│       │   │           └── controller
│       │   │               ├── restaurant
│       │   │               │   └── RestaurantController.java
│       │   │               └── user
│       │   │                   └── UserController.java
│       │   └── resources
│       │       └── application.yaml
│       └── test
│           ├── java
│           └── resources
├── application
│   ├── build.gradle
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── telivery
│       │   │           ├── Application.java
│       │   │           └── persistence
│       │   │               ├── restaurant
│       │   │               │   └── RestaurantService.java
│       │   │               └── user
│       │   │                   ├── UserService.java
│       │   │                   └── dto
│       │   │                       └── UserInfoDto.java
│       │   └── resources
│       └── test
│           ├── java
│           └── resources
├── build.gradle
├── domain
│   ├── build.gradle
│   └── src
│       ├── main
│       │   └── java
│       │       └── com
│       │           └── telivery
│       │               ├── common
│       │               │   ├── PagingResponse.java
│       │               │   ├── ServiceResponse.java
│       │               │   └── ServiceResponseCode.java
│       │               ├── exception
│       │               │   └── ServiceExceptionType.java
│       │               └── persistence
│       │                   ├── entity
│       │                   │   ├── Restaurant.java
│       │                   │   ├── User.java
│       │                   │   └── type
│       │                   │       └── Role.java
│       │                   └── repository
│       │                       └── UserRepository.java
│       └── test
│           ├── java
│           └── resources
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
└── settings.gradle

```