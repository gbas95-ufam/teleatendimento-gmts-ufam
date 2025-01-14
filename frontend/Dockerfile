# imagem
FROM gradle:7.6.0-jdk11

# configura diretório de trabalho no container
WORKDIR /app

# copia o conteúdo do projeto p/ o cantainer
COPY . /app/

# expoe a porta do gradle
EXPOSE 8080

# inicia a aplicação
CMD ["./gradlew", "bootRun"]

# EXECUÇÃO NO TERMINAL
# docker build -t meu-projeto-grails:1.0 .
# docker run -p 8080:8080 meu-projeto-grails:1.0