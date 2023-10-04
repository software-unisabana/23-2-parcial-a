FROM openjdk
WORKDIR /app
COPY . /app
CMD ["java", "parcial"]

