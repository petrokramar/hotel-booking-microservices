FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Petro Kramar <peter.v.kramar@gmail.com>
ADD target/discovery-service-1.0.0.jar /app
CMD ["java", "-Xmx200m", "-server", "-jar", "/app/discovery-service-1.0.0.jar"]
EXPOSE 8761