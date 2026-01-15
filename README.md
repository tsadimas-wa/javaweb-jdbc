# HR Project - Java JDBC Web Application

Αυτό το project είναι μια πλήρης Java Web εφαρμογή που επιδεικνύει τη σύνδεση με βάση δεδομένων PostgreSQL χρησιμοποιώντας JDBC, αρχιτεκτονική MVC, Servlets, JSP και JSTL.

Η εφαρμογή αναπτύχθηκε στα πλαίσια εκπαιδευτικού εργαστηρίου για την κατανόηση της επικοινωνίας Java και Βάσεων Δεδομένων.

## 🚀 Χαρακτηριστικά

* **Αρχιτεκτονική MVC:** Διαχωρισμός λογικής (Controller), δεδομένων (Model) και εμφάνισης (View).
* **Database Connectivity:** Σύνδεση με PostgreSQL μέσω JDBC Driver.
* **User Management:** Εγγραφή χρηστών και εμφάνιση λίστας εγγεγραμμένων χρηστών.
* **Secure Implementation:** Χρήση `WEB-INF` για προστασία των JSP σελίδων και αποφυγή SQL Injection μέσω `PreparedStatement`.
* **JSTL & CSS:** Καθαρός κώδικας στα Views και μοντέρνα εμφάνιση.

## 🛠️ Τεχνολογίες

* **Java JDK 17+**
* **Apache Tomcat 10.1+**
* **PostgreSQL** (Database)
* **Maven** (Dependency Management)
* **JDBC** (Java Database Connectivity)
* **JSP & JSTL** (Jakarta Standard Tag Library)
* **HTML5 / CSS3**

## ⚙️ Εγκατάσταση και Ρύθμιση

### 1. Clone Repository
```bash
git clone [https://github.com/ΤΟ_USERNAME_ΣΟΥ/hrproject.git](https://github.com/ΤΟ_USERNAME_ΣΟΥ/hrproject.git)
cd hrproject
```

### 2. Ρύθμιση Βάσης Δεδομένων
Εκτελέστε τα παρακάτω SQL scripts στην PostgreSQL βάση σας (π.χ. μέσω pgAdmin ή Render Shell) για να δημιουργήσετε τους πίνακες:


```SQL

-- 1. Create Jobs Table
CREATE TABLE jobs (
    job_id SERIAL PRIMARY KEY,
    job_title VARCHAR(100) NOT NULL
);

-- 2. Insert dummy jobs
INSERT INTO jobs (job_title) VALUES ('Software Engineer'), ('HR Manager'), ('Sales Rep');

-- 3. Create Users Table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    job_id INT REFERENCES jobs(job_id),
    password VARCHAR(255) DEFAULT '1234' -- Προαιρετικό πεδίο αν υλοποιηθεί Login
);
```

### 3. Ρύθμιση Σύνδεσης (Context.xml)
Για να τρέξει τοπικά η εφαρμογή, πρέπει να δημιουργήσετε το αρχείο src/main/webapp/META-INF/context.xml (αν δεν υπάρχει) και να προσθέσετε τα δικά σας στοιχεία σύνδεσης:

```xml

<?xml version="1.0" encoding="UTF-8"?>
<Context path="/hrproject">
    <Environment name="DB_URL" 
                 value="jdbc:mysql://localhost:3306/hr_db?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=UTC" 
                 type="java.lang.String" override="false"/>

    <Environment name="DB_USER" value="root" type="java.lang.String" override="false"/>
    <Environment name="DB_PASSWORD" value="" type="java.lang.String" override="false"/>
</Context>
```
### 4. Build & Run
Ανοίξτε το project με το NetBeans (ή IntelliJ/Eclipse):
* Κάντε Clean and Build για να κατέβουν οι βιβλιοθήκες μέσω Maven.
* Τρέξτε το project (Run) στον Apache Tomcat server.

### Δομή Φακέλων (MVC)
Η δομή του project ακολουθεί το πρότυπο Model-View-Controller:

* src/main/java/gr/uniwa/ice/hrproject/
    * db/: Περιέχει τους DAOs (UserDAO, ProductDAO) και τη σύνδεση (DatabaseConnection). (Model)
    * entity/: Περιέχει τις κλάσεις POJO (User, Product). (Model)
    * servlet/: Περιέχει τα Servlets (RegisterServlet, ListUsersServlet). (Controller)

* src/main/webapp/
    * WEB-INF/jsp/: Περιέχει τα αρχεία εμφάνισης (register.jsp, list_users.jsp). (View)
    * css/: Περιέχει το style.css.

### Endpoints
* /testdb: Έλεγχος σύνδεσης με τη βάση δεδομένων.
* /register: Φόρμα εγγραφής νέου χρήστη.
* /list_users: Λίστα με όλους τους εγγεγραμμένους χρήστες.


### ▶️ Τρόποι Εκτέλεσης
*Μέθοδος Α: Μέσω NetBeans (GUI)
    * Ανοίξτε το project με το NetBeans.
    * Κάντε Clean and Build (για λήψη βιβλιοθηκών Maven).
    * Πατήστε Run (το project θα τρέξει στον ενσωματωμένο Tomcat server).

* Μέθοδος Β: Μέσω Τερματικού (Maven Cargo)
Μπορείτε να τρέξετε την εφαρμογή χωρίς το NetBeans, απευθείας από τη γραμμή εντολών.
Προαπαιτούμενο: Βεβαιωθείτε ότι στο pom.xml έχετε προσθέσει το cargo-maven3-plugin στο section <build><plugins>.

1. Ανοίξτε τερματικό μέσα στον φάκελο του project.
2. Εκτελέστε την εντολή:

```bash
mvn clean package cargo:run
```

3. Η εφαρμογή θα ξεκινήσει αυτόματα (θα κατέβει local Tomcat 10).

3. Ανοίξτε στον browser: http://localhost:8081/hrproject

(Για τερματισμό πατήστε Ctrl + C στο τερματικό)



Postgres in docker
```bash
docker run --name postgres-db --rm  \
-e POSTGRES_PASSWORD=mypassword \
-e POSTGRES_USER=myuser \
-e POSTGRES_DB=hrdb \
-p 5432:5432 \
-v postgres-data:/var/lib/postgresql/data \
-d postgres:17
``` 
