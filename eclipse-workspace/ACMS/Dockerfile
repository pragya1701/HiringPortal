FROM maven:3-jdk-8
COPY . /appuser
ADD /target/SpringDockerUser.war SpringDockerUser.war
ENTRYPOINT ["java","-jar","/SpringDockerUser.war"]
