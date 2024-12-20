# Step 1: Build the Angular app using Node.js
FROM node:18 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the rest of your application files
COPY . .

# Build the Angular project for production
RUN npm run build --prod

# Step 2: Serve the app using an HTTP server
FROM nginx:alpine

# Copy the build output to the Nginx html directory
COPY --from=build /app/dist/your-angular-app-name /usr/share/nginx/html

# Expose port 80 for the Nginx server
EXPOSE 80

# Start the Nginx server
CMD ["nginx", "-g", "daemon off;"]
