# Movie Ticket Booking System

A Java-based web application that provides an end-to-end movie ticket booking experience. Users can create accounts, browse movies, choose a preferred mall or theatre, select showtimes, select seats, complete payments, and receive electronic tickets.

Live Demo
The Movie Ticket Booking System is deployed and accessible online.
Application URL: https://movieticketbooking-tlbp.onrender.com

## Features

- **User Registration:** Create a new user account.
- **User Authentication:** Log in to access the application.
- **Movie Browsing:** Explore currently available and upcoming movies.
- **Mall / Theatre Selection:** Browse and select a preferred mall or theatre.
- **Show Selection:** View and select available movie showtimes.
- **Seat Selection:** Select preferred seats for a particular show.
- **Movie Booking:** Complete the movie ticket booking process.
- **Payment:** Proceed with the booking payment process.
- **E-Ticket Generation:** Receive an electronic ticket after successful booking.

## Technology Stack

| Category | Technology |
|---|---|
| Programming Language | Java (JDK 25) |
| Frontend | JSP, HTML, CSS, JavaScript |
| Backend | Java Servlets |
| Data Representation | JavaBeans |
| Database Access | DAO (Data Access Object) |
| Database | MySQL |
| Connection Pooling | HikariCP |
| Application Server | Apache Tomcat 11 |
| IDE | Eclipse IDE |
| Version Control | Git and GitHub |

## Application Workflow

1. Register a new account or log in.
2. Browse and select a movie.
3. Choose a preferred mall or theatre.
4. View available shows and select a showtime.
5. View the seat layout and select preferred seats.
6. Proceed with the booking and payment process.
7. Receive the electronic ticket after successful booking.

## Application Architecture

The application follows a structured approach that separates presentation, request handling, application data, and database operations.

| Component | Responsibility |
|---|---|
| JSP | Displays dynamic web pages and application content. |
| HTML | Defines the structure of web pages. |
| CSS | Handles styling and responsive layouts. |
| JavaScript | Implements client-side interactions and validations. |
| Servlets | Handle HTTP requests and coordinate application workflows. |
| JavaBeans | Represent and transfer application data. |
| DAO | Encapsulates database operations. |
| HikariCP | Manages database connection pooling. |
| MySQL | Stores application data. |
| Apache Tomcat | Hosts and runs the Java web application. |


Data Flow Diagrams (DFD)

Level 0 DFD (Context Diagram)
<img width="966" height="487" alt="image" src="https://github.com/user-attachments/assets/4b8d6d27-4988-460a-9b71-9c6f164bf0cb" />

Level 1 DFD
<img width="975" height="432" alt="image" src="https://github.com/user-attachments/assets/92b3689a-fd19-4653-b791-6a8f71863f3f" />

Entity Relationship Diagram (ER Diagram)
<img width="1086" height="1389" alt="image" src="https://github.com/user-attachments/assets/f263ed7d-1973-4776-9daa-1996949c88be" />



## Project Structure

```text
MovieTicketBooking/
│
├── database/
│   ├── schema.sql
│   └── seed.sql
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── com/
│       │   │   └── movieticket/
│       │   │       ├── controller/
│       │   │       ├── dao/
│       │   │       ├── filter/
│       │   │       ├── model/
│       │   │       ├── test/
│       │   │       └── util/
│       │   │
│       │   └── db.properties.example
│       │
│       └── webapp/
│           ├── assets/
│           │   ├── css/
│           │   └── js/
│           │
│           ├── WEB-INF/
│           │   └── lib/
│           │
│           └── *.jsp
│
├── .classpath
├── .project
├── .settings/
├── .gitignore
├── LICENSE
└── README.md
```

## Getting Started

Follow the instructions below to configure and run the project locally.

### Prerequisites

Install the following software:

- **JDK 25:** Java Development Kit.
- **Apache Tomcat 11:** Java web application server.
- **MySQL Server:** Relational database management system.
- **Eclipse IDE for Enterprise Java and Web Developers:** Recommended IDE for Java web application development.
- **Git:** Version control system.

### Official Download Links

| Software | Official Download |
|---|---|
| JDK 25 | [Download JDK 25](https://jdk.java.net/25/) |
| Apache Tomcat 11 | [Download Tomcat 11](https://tomcat.apache.org/download-11.cgi) |
| MySQL Server | [Download MySQL](https://dev.mysql.com/downloads/mysql/) |
| Eclipse IDE | [Download Latest Eclipse IDE](https://www.eclipse.org/downloads/packages/) |
| Git | [Download Git](https://git-scm.com/downloads) |

**Eclipse Recommendation:** Download the latest available Eclipse IDE for Enterprise Java and Web Developers (Windows 64-bit for Windows users). This package includes the tools required for Java, JSP, Servlet, and web application development.

## Installation and Configuration

### 1. Clone the Repository

Clone the project from GitHub.

```bash
git clone <https://github.com/mdahsankamal/MovieTicketBooking>
```

Open the cloned project directory in Eclipse.

Import the project using:

**File → Import → Existing Projects into Workspace**

Select the cloned repository folder and complete the import.

### 2. Create and Initialize the Database

1. Start your MySQL server.
2. Open Beekeeper Studio or MySQL Workbench or  another MySQL client.
3. Create the required database/schema.
4. Locate the database schema SQL script in the `database/` directory.
5. Execute the schema script.
6. Locate the seed SQL script.
7. Execute the seed script to insert the initial/sample data.

**Important:** Execute the schema script first and the seed script afterward.

### 3. Configure Database Credentials

1. Locate `db.properties.example` inside `src/main/java/`.
2. Copy the example file.
3. Create a new file named `db.properties` in the same location.
4. Open `db.properties`.
5. Enter your own MySQL database credentials, including the JDBC URL, username, and password.
6. Save the file.

Example configuration for a local MySQL server:

```properties
DB_URL=jdbc:mysql://localhost:3306/movie_verse
DB_USER=root
DB_PASSWORD=your_password
```

Replace the example credentials with your actual MySQL database credentials.

**Security:** Do not upload your personal `db.properties` file or database passwords to GitHub. Keep the example file free of real credentials.

### 4. Verify the Database Connection

You can test the database connection independently without starting the Tomcat server.

1. Open **Run → Run Configurations**.
2. Double-click **Java Application** on the left.
3. Under **Main**, configure the following:
   - **Project:** `MovieTicketBooking`
   - **Main class:** `com.movieticket.util.DBConnection`
4. Click **Search...** beside Main class and select `DBConnection` if it appears.
5. Click **Run**.
6. Check the Eclipse Console for the connection result.

**Expected successful output:**

```text
DB CONNECTION TIME: 250 ms
DATABASE CONNECTED SUCCESSFULLY!
```

The connection time may vary depending on your database server and network.

**Note:** `DBConnection.java` must contain a `public static void main(String[] args)` method for standalone execution. The MySQL JDBC driver, HikariCP dependencies, and `db.properties` must also be available on the runtime classpath.

### 5. Configure JDK 25 in Eclipse

1. Open Eclipse.
2. Navigate to **Window → Preferences → Java → Installed JREs**.
3. Add the installed JDK 25 directory if it is not already configured.
4. Select JDK 25 as the active JDK.
5. Navigate to **Java → Compiler** and configure the compiler compliance level to 25.
6. Verify the project's Java build-path settings.

### 6. Configure Apache Tomcat 11 in Eclipse

1. Open the **Servers** view in Eclipse.
2. If the Servers view is not visible, navigate to **Window → Show View → Other → Server → Servers**.
3. Click **Create a new server**.
4. Select **Apache → Tomcat v11.0 Server**.
5. Click **Next**.
6. Browse to your local Apache Tomcat 11 installation directory.
7. Select JDK 25 as the server JRE.
8. Complete the server configuration.
9. Add the MovieTicketBooking project to the configured Tomcat server.

### 7. Configure Tomcat Server Ports

Configure the following ports in Eclipse.

| Port Setting | Purpose | Port Number |
|---|---|---:|
| HTTP/1.1 | Application access | `8081` |
| Tomcat admin port | Server shutdown | `8005` |

**Steps to change the ports:**

1. Open the **Servers** view in Eclipse.
2. Double-click **Tomcat v11.0 Server at localhost**.
3. Locate the **Ports** section in the server configuration.
4. Change the HTTP/1.1 port from `8080` to `8081`.
5. Keep the Tomcat admin port as `8005`.
6. Save the server configuration using `Ctrl + S`.

**Application URL:**

```text
http://localhost:8081/MovieTicketBooking/
```

The context path may differ depending on the project's configured context root.

### 8. Run the Application

1. Ensure that MySQL is running.
2. Verify that the database connection test succeeds.
3. Confirm that JDK 25 and Tomcat 11 are configured.
4. Ensure that the Tomcat HTTP/1.1 port is `8081` and the Tomcat admin port is `8005`.
5. Right-click the project in Eclipse.
6. Select **Run As → Run on Server**.
7. Select the configured Apache Tomcat 11 server.
8. Start the application.
9. Open the application using the configured local URL.

## Database Connection Troubleshooting

If the database connection test fails with a `Communications link failure` or `Connection refused` exception, follow these troubleshooting steps.

### 1. Check the MySQL Server Status

First, verify that the MySQL server is running.

**Option A: If MySQL is running through Docker**

1. Open Command Prompt or PowerShell.
2. List all Docker containers:

```bash
docker ps -a
```

3. Locate the MySQL container (for example, `mysql-db`).
4. If the container is stopped, start it:

```bash
docker start mysql-db
```

5. Verify that the container is running:

```bash
docker ps
```

6. Check that port `3306` is correctly mapped to the host.

Example:

```text
0.0.0.0:3306->3306/tcp
```

**Option B: If MySQL is installed directly on Windows**

1. Press `Win + R`.
2. Enter `services.msc`.
3. Find the installed MySQL service (for example, `MySQL80`).
4. Check its status.
5. If the service is stopped, right-click it and select **Start**.

### 2. Verify Database Configuration

Open your local `db.properties` file and verify the following values:

```properties
DB_URL=jdbc:mysql://localhost:3306/movie_verse
DB_USER=root
DB_PASSWORD=your_password
```

Verify that:

- The hostname is correct.
- The MySQL port is correct.
- The database name exists.
- The username is correct.
- The password is correct.
- The MySQL server accepts connections on the configured address and port.

**Note:** If your MySQL server uses a different port, update the JDBC URL accordingly.

### 3. Check Whether MySQL Port 3306 Is Listening

Open Windows Command Prompt and execute:

```cmd
netstat -ano | findstr :3306
```

If MySQL is listening on port `3306`, the output should contain a `LISTENING` entry.

If no output appears:

- Check whether the MySQL service is running.
- Verify the Docker container status if using Docker.
- Verify the Docker port mapping.
- Confirm that MySQL is configured to use port `3306`.

### 4. Understand the SLF4J Warning

You may encounter the following warning while running the database connection test:

```text
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation.
```

This is a logging configuration warning, not the cause of a database connection failure.

HikariCP can still attempt to establish database connections.

If you want HikariCP logging, add an SLF4J logging provider compatible with your installed SLF4J API version.

### 5. Common Database Connection Errors

| Error | Possible Cause | Solution |
|---|---|---|
| Communications link failure | MySQL server is unreachable | Start MySQL and verify the hostname and port. |
| Connection refused | No server is listening on the configured port | Check MySQL service status and port mapping. |
| Access denied for user | Incorrect username or password | Verify `DB_USER` and `DB_PASSWORD`. |
| Unknown database | Database does not exist | Create the database and execute the schema script. |
| db.properties not found | Configuration file is missing from the runtime classpath | Place it in the expected classpath location. |
| MySQL JDBC driver missing | Connector/J is unavailable | Verify the MySQL JDBC driver dependency. |
| No SLF4J providers found | No logging implementation is configured | Add a compatible SLF4J provider if logging is required. |

## Security Guidelines

- Never commit database credentials or passwords.
- Keep personal `db.properties` files out of version control.
- Do not expose API keys or other sensitive configuration values.
- Avoid publishing real user or payment information in screenshots or sample data.

## Version Control

This project uses Git for source-code version control and GitHub for repository hosting.

Clone the repository using the command provided in the setup instructions.

## License

This project is licensed under the **MIT License**.

You are free to use, copy, modify, merge, publish, distribute, sublicense, and sell copies of the software, subject to the conditions of the MIT License.

See the [LICENSE](LICENSE) file for the complete license terms.
