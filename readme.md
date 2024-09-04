# Animal Shelter Backend 🐶🐱🐾

## 🌟 Project Description

This project involves developing the backend of a web application for an animal shelter using Spring Boot. The primary goal of the application is to allow users to view advertisements for pets that need a home and to facilitate adoptions. Additionally, the application will include functionality to accept donations and a system for authentication and authorization based on Spring Security and JWT (JSON Web Token).

## 🚀 Project Objectives

1. **Reinforce API creation concepts.**
2. **Apply relational database relationships.**
3. **Develop an authentication and authorization system using Spring Security and JWT.**

## 🛠️ Functional Requirements

### Pet Listings

- **List Pets:** Retrieve a list of all pets available for adoption.
- **Pet Details:** View detailed information about a specific pet.
- **Add Pets:** Allow administrators to add new pets to the system.
- **Update Pets:** Allow administrators to modify existing pet information.
- **Delete Pets:** Allow administrators to remove a pet from the system.

### Donations

- **Create Donations:** Users can fill out a form to make donations to the shelter.
- **List Donations:** View a list of donations made (accessible only to administrators).
- **View Donation Details:** View the details of a specific donation.
- **Edit or Delete Donations:** Allow administrators to edit or delete donations from the system.

### Authentication and Authorization

- **Authentication:** Implement a login system that allows users to authenticate using Spring Security and JWT.
- **Authorization:**
  - Users can view pets and make donations without authentication.
  - Administrators will have additional permissions to manage pets and donations.

## 💻 Technical Requirements

- Knowledge of programming in Java.
- Understanding of Object-Oriented Programming (OOP).
- Experience with Spring Boot.
- Familiarity with Spring Security and JWT.
- Ability to write and execute automated tests.
- Familiarity with Docker.

## ⚙️ Installation and Deployment Instructions 

### Prerequisites

- **Java 11 or higher**
- **Maven**
- **Docker**
- **MySQL**

### Development Environment Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/username/animal-shelter-backend.git
   cd animal-shelter-backend
   ```

2. **Configure the Database:**

   Make sure you have a running MySQL database. You can configure the connection details in the `application.properties` file.

3. **Build and Run the Application:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Deploy with Docker:**

   ```bash
   docker-compose up --build
   ```

   This will build and run the necessary containers, including the backend and the database.

### Testing

To run the tests, use the following command:

```bash
mvn test
```

##  🤝 Contributions

This project was developed collaboratively by[[FJRJ3D](https://github.com/FJRJ3D), [jmco1999](https://github.com/jmcp1999), [Krisel1](https://github.com/Krisel1) and [EvaMartinez94](https://github.com/EvaMartinez94). Contributions are welcome! Please fork this repository, create a new branch for your feature or bugfix, and submit a pull request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
