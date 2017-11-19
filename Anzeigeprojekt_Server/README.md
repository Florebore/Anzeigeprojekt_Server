# Build
mvn clean package && docker build -t com.flope/Anzeigeprojekt_Server .

# RUN

docker rm -f Anzeigeprojekt_Server || true && docker run -d -p 8080:8080 -p 4848:4848 --name Anzeigeprojekt_Server com.flope/Anzeigeprojekt_Server 