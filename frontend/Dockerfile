FROM node:latest as build

WORKDIR /app

COPY package*.json ./

RUN npm ci

RUN npm install -g @angular/cli

COPY . .

RUN npm run build --configuration=production

FROM nginx:latest

COPY nginx.conf /etc/nginx/nginx.conf

COPY --from=build app/dist/frontend /usr/share/nginx/html

EXPOSE 4200