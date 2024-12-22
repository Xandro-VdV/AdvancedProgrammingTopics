# Step 1: Build the Angular app using Node.js
FROM node:18 AS build

# Set the working directory for your app
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the Angular project for production
RUN npm run build --prod

# Step 2: Serve the app using Nginx
FROM nginx:alpine

# Copy the custom Nginx configuration file
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copy the built Angular app from the build stage to the Nginx html directory
COPY --from=build /app/dist/frontend /usr/share/nginx/html

# Expose port 80 (default HTTP port)
EXPOSE 80

# Start the Nginx server
CMD ["nginx", "-g", "daemon off;"]
