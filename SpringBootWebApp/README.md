## To create GKE cluster in GCP - Refer Repo for steps - https://github.com/KR-CloudOPS/CICD-Terraform

# Spring Boot Web Application Deployment

## 1. Build the Spring Boot Application (Choose between Maven or Docker for the build process)

Run the following command to package your Spring Boot application using Maven:

```bash
mvn clean package

# 2. Build and Push the Docker Image

docker build --platform linux/amd64 -t springbootwebapp .
docker tag  springbootwebapp gcr.io/<project ID>/springbootwebapp:v1.0
docker push gcr.io/vibrant-waters-429918-r1/springbootwebapp:v1.0


# 3. Database Dependency

Install PostgreSQL. Here are the steps using Homebrew for local setup:
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew update
brew install postgresql
brew services start postgresql
psql --version
psql postgres

Create a user and database in PostgreSQL:
CREATE USER <YOUR_USERNAME> WITH PASSWORD '<PASSWORD>';
CREATE DATABASE <DatabaseName>;
GRANT ALL PRIVILEGES ON DATABASE <DatabaseName> TO <YOUR_USERNAME>;
\q

Connect to the DB using the following command:

psql -h host -p 5432 -U username -d databasename

Create the table:
CREATE TABLE IF NOT EXISTS user_input (
  id SERIAL PRIMARY KEY,
  content VARCHAR(255) NOT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

# 4. Update application.properties and Build and Deploy

Update your application.properties file with the necessary database configuration, then build and deploy your application.

# 5. Run Locally

Run the application locally using the following command:
java -jar SpringBootWebApp-1.0.0.jar

# 6. App Deployment in Kubernetes (Sample Scripts Below; Modify Accordingly)
Update the Database Properties:

Modify the database properties in the secret-* files. Although base64 encoding is used for simplicity, consider using KMS keys or a strong encryption/decryption model for enhanced security.

Deploy the Application:

Update the Docker image in your Kubernetes deployment configuration and then apply the configuration.
kubectl apply -f k8s-deployment/test/deployment-test.*
