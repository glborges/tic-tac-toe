# 🎮 Tic-Tac-Toe Application

This is a **Spring Boot** command-line application that allows users to play **Tic-Tac-Toe** via the terminal.

## 🛠 Requirements

Before running the application, ensure you have:

- **Java 21** installed  
  Verify by running:
  ```bash
  java -version
  ```
- **Maven** installed  
  Verify by running:
  ```bash
  mvn -version
  ```

## 🚀 Running the Application

### 1️⃣ **Clone the Repository**
```bash
git clone https://github.com/glborges/tic-tac-toe.git
cd tic-tac-toe
```

### 2️⃣ **Build the Project**
Compile the project using Maven:
```bash
mvn clean package
```

### 3️⃣ **Run the Application**
You can run the application in two ways:

#### ✅ **Using Maven**
```bash
mvn spring-boot:run
```

## 🧪 Running Tests
To run unit tests:
```bash
mvn test
```

## 🛠 Troubleshooting
### **Java Version Issues**
If you see errors related to Java versions, ensure your `JAVA_HOME` is set correctly:
```bash
export JAVA_HOME=/path/to/java21
```

### **Maven Build Issues**
If you face build issues, try:
```bash
mvn clean install -U
```

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



