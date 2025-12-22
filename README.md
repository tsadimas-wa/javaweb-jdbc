# HR Project - Java JDBC Web Application

Αυτό το project είναι μια πλήρης Java Web εφαρμογή που επιδεικνύει τη σύνδεση με βάση δεδομένων MySQL χρησιμοποιώντας JDBC, αρχιτεκτονική MVC, Servlets, JSP και JSTL.

Η εφαρμογή αναπτύχθηκε στα πλαίσια εκπαιδευτικού εργαστηρίου για την κατανόηση της επικοινωνίας Java και Βάσεων Δεδομένων.

## 🚀 Χαρακτηριστικά

* **Αρχιτεκτονική MVC:** Διαχωρισμός λογικής (Controller), δεδομένων (Model) και εμφάνισης (View).
* **Database Connectivity:** Σύνδεση με MYSQL μέσω JDBC Driver.
* **User Management:** Εγγραφή χρηστών και εμφάνιση λίστας εγγεγραμμένων χρηστών.
* **Secure Implementation:** Χρήση `WEB-INF` για προστασία των JSP σελίδων και αποφυγή SQL Injection μέσω `PreparedStatement`.
* **JSTL & CSS:** Καθαρός κώδικας στα Views και μοντέρνα εμφάνιση.

## 🛠️ Τεχνολογίες

* **Java JDK 17+**
* **Apache Tomcat 10.1+**
* **MySQL** (Database)
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
Εκτελέστε τα παρακάτω SQL scripts στην MYSQL βάση σας για να δημιουργήσετε τους πίνακες:


```SQL
CREATE TABLE jobs (
    job_id INT PRIMARY KEY AUTO_INCREMENT,
    job_title VARCHAR(100) NOT NULL
);

-- 2. Insert dummy jobs so we can link users to them
INSERT INTO jobs (job_title) VALUES ('Software Engineer'), ('HR Manager'), ('Sales Rep');

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,  -- Η σύνταξη της MySQL
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    job_id INT,
    FOREIGN KEY (job_id) REFERENCES jobs(job_id)
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
📂
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