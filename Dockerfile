# 베이스 이미지 선택
FROM openjdk:17.0.1-jdk-slim

# 애플리케이션 디렉토리 생성
WORKDIR /app

# 호스트의 JAR 파일을 컨테이너로 복사
# Copy the compiled JAR file to the container
COPY build/libs/*.jar app.jar

# Copy the application.properties file to the container
COPY ./src/main/resources/application.properties /app/application.properties

# Set the entrypoint command
CMD ["java", "-jar", "app.jar"]
