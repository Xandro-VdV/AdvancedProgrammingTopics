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
RUN npm run build

# Step 2: Serve the app using http-server
FROM node:18-alpine

# Install http-server globally
RUN npm install -g http-server

# Set the working directory to serve the build
WORKDIR /usr/share/frontend

# Copy the Angular build output from the build stage
COPY --from=build /app/dist/frontend .

# Expose port 80 for the http-server
EXPOSE 80

# Start http-server
CMD ["http-server", "-p", "80"]
