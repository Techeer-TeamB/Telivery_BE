FROM openjdk:11-jdk

WORKDIR /server
ADD . /server/ /server/

CMD ["./gradlew", "bootRun"]