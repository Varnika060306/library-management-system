# 📚 Library Management System - Complete CI/CD Pipeline

A simple Library Management System built with Spring Boot, demonstrating a complete DevOps CI/CD pipeline using **Git, Jenkins, Maven, Docker, Kubernetes,** and **Ansible**.

## 🎯 Project Overview

This project implements an end-to-end DevOps pipeline that automates the entire software delivery process — from source code to production deployment — for a Library Management System with full CRUD functionality.

## 🏗️ Architecture

```
Developer → Git → Jenkins → Maven Build → Unit Tests
                              ↓
                         Docker Image Build
                              ↓
                      Push to Docker Registry
                              ↓
                      Ansible Automation
                              ↓
                     Kubernetes Deployment
                              ↓
                    Application Running (3 Pods)
```

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Application** | Java 17, Spring Boot 3.2 |
| **Database** | H2 (In-Memory) |
| **Version Control** | Git / GitHub |
| **CI/CD** | Jenkins |
| **Build Tool** | Apache Maven |
| **Containerization** | Docker |
| **Orchestration** | Kubernetes |
| **Configuration Mgmt** | Ansible |

## 📁 Project Structure

```
library-management-system/
├── src/                              # Application source code
│   ├── main/java/com/library/
│   │   ├── LibraryManagementApplication.java
│   │   ├── controller/               # REST API controllers
│   │   ├── model/                    # JPA entity models
│   │   ├── repository/               # JPA repositories
│   │   └── service/                  # Business logic
│   ├── main/resources/
│   │   ├── application.properties
│   │   └── data.sql
│   └── test/java/                    # JUnit tests
├── k8s/                              # Kubernetes manifests
│   ├── namespace.yaml
│   ├── deployment.yaml
│   ├── service.yaml
│   ├── configmap.yaml
│   └── hpa.yaml
├── ansible/                          # Ansible automation
│   ├── inventory.ini
│   ├── deploy-playbook.yml
│   └── setup-prerequisites.yml
├── Dockerfile                        # Container image definition
├── Jenkinsfile                       # CI/CD pipeline definition
├── pom.xml                           # Maven build file
├── .gitignore
├── .dockerignore
└── README.md
```

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.9+
- Docker 20+
- Kubernetes (Minikube/kind/k3s)
- Ansible 2.9+
- Jenkins 2.400+

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/library-management-system.git
cd library-management-system
```

### 2️⃣ Build with Maven
```bash
mvn clean package
```

### 3️⃣ Run Locally
```bash
java -jar target/library-management-system.jar
# Access at http://localhost:8080
```

### 4️⃣ Build Docker Image
```bash
docker build -t library-management-system:latest .
docker run -p 8080:8080 library-management-system:latest
```

### 5️⃣ Deploy with Ansible
```bash
ansible-playbook -i ansible/inventory.ini ansible/deploy-playbook.yml
```

### 6️⃣ Deploy to Kubernetes (Manual)
```bash
kubectl apply -f k8s/namespace.yaml
kubectl apply -f k8s/configmap.yaml -n library-app
kubectl apply -f k8s/deployment.yaml -n library-app
kubectl apply -f k8s/service.yaml -n library-app
kubectl apply -f k8s/hpa.yaml -n library-app

kubectl get pods -n library-app
kubectl get svc -n library-app
```

## 🔄 Jenkins Pipeline Stages

| # | Stage | Description |
|---|-------|-------------|
| 1 | Checkout from Git | Clone repository |
| 2 | Build with Maven | Compile source code |
| 3 | Run Unit Tests | Execute JUnit tests |
| 4 | Package Application | Build JAR file |
| 5 | Code Quality Check | Static analysis |
| 6 | Build Docker Image | Create container image |
| 7 | Push to Registry | Upload to Docker Hub |
| 8 | Deploy with Ansible | Run automation playbook |
| 9 | Deploy to Kubernetes | Apply K8s manifests |
| 10 | Verify Deployment | Health checks |

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books` | List all books |
| GET | `/api/books/{id}` | Get book by ID |
| POST | `/api/books` | Create new book |
| PUT | `/api/books/{id}` | Update existing book |
| DELETE | `/api/books/{id}` | Delete book |
| GET | `/api/books/available` | List available books |
| GET | `/api/books/health` | Health check |

### Sample API Request
```bash
# Add a new book
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Effective Java",
    "author": "Joshua Bloch",
    "isbn": "978-0134685991",
    "category": "Programming",
    "available": true
  }'

# Get all books
curl http://localhost:8080/api/books
```

## 🧪 Setting Up Jenkins Pipeline

1. **Install Required Jenkins Plugins:**
   - Git Plugin
   - Pipeline Plugin
   - Docker Pipeline Plugin
   - Kubernetes CLI Plugin
   - Ansible Plugin

2. **Configure Tools in Jenkins:**
   - Maven (named: `Maven-3.9`)
   - JDK 17 (named: `JDK-17`)

3. **Add Credentials:**
   - DockerHub: `dockerhub-credentials`
   - Kubernetes config: `kubeconfig`

4. **Create New Pipeline:**
   - New Item → Pipeline
   - Pipeline script from SCM
   - Repository URL: your Git repo
   - Script Path: `Jenkinsfile`

5. **Run the Pipeline** by clicking *Build Now*.

## 📸 Submission Screenshots

Place screenshots in the `/screenshots` folder:
- `01-jenkins-pipeline.png` — Jenkins pipeline execution
- `02-docker-build.png` — Docker image build output
- `03-docker-images.png` — `docker images` output
- `04-kubectl-pods.png` — Running K8s pods
- `05-kubectl-services.png` — K8s services
- `06-app-running.png` — Application UI in browser
- `07-api-response.png` — REST API response

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| Maven build fails | Check Java version: `java -version` |
| Docker push denied | Re-login: `docker login` |
| Pod CrashLoopBackOff | `kubectl logs <pod-name> -n library-app` |
| Service not accessible | Check NodePort: `kubectl get svc -n library-app` |

## 👨‍💻 Author

**DevOps Lab Project**
Library Management System with integrated CI/CD pipeline.

## 📄 License

This project is for educational purposes.
