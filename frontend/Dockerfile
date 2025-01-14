# Use uma imagem base com Node.js
FROM node:16

# Definir o diretório de trabalho para o frontend
WORKDIR /app

# Copiar os arquivos de dependências (package.json e package-lock.json)
COPY package*.json ./

# Instalar as dependências do React
RUN npm install

# Copiar o restante dos arquivos da aplicação React
COPY . .

# Construir o projeto React
RUN npm run build

# Expõe a porta 3000
EXPOSE 3000

# Comando para iniciar a aplicação React (em modo de produção)
CMD ["npm", "start"]
