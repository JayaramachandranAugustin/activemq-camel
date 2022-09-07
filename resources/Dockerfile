# Using jdk as base image
FROM openjdk:17-alpine
# Copy the whole directory of activemq into the image
COPY apache-activemq-5.17.2 /opt/apache-activemq-5.17.2
# Set the working directory to the bin folder
WORKDIR /opt/apache-activemq-5.17.2/bin

EXPOSE 61616 8161
# Start up the activemq server
ENTRYPOINT ["./activemq","console"]