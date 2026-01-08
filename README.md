# HR Project - Java JDBC Web Application

Αυτό το project είναι μια πλήρης Java Web εφαρμογή που επιδεικνύει τη σύνδεση με βάση δεδομένων SQLite χρησιμοποιώντας JDBC, αρχιτεκτονική MVC, Servlets, JSP και JSTL.

Η εφαρμογή αναπτύχθηκε στα πλαίσια εκπαιδευτικού εργαστηρίου για την κατανόηση της επικοινωνίας Java και Βάσεων Δεδομένων.

## 🚀 Χαρακτηριστικά

* **Αρχιτεκτονική MVC:** Διαχωρισμός λογικής (Controller), δεδομένων (Model) και εμφάνισης (View).
* **Database Connectivity:** Σύνδεση με SQLite μέσω JDBC Driver.
* **User Management:** Εγγραφή χρηστών και εμφάνιση λίστας εγγεγραμμένων χρηστών.
* **Secure Implementation:** Χρήση `WEB-INF` για προστασία των JSP σελίδων και αποφυγή SQL Injection μέσω `PreparedStatement`.
* **JSTL & CSS:** Καθαρός κώδικας στα Views και μοντέρνα εμφάνιση.

## 🛠️ Τεχνολογίες

* **Java JDK 17+**
* **Apache Tomcat 10.1+**
* **SQLite** (Database)
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
Εκτελέστε τα παρακάτω SQL scripts στην SQLite βάση σας για να δημιουργήσετε τους πίνακες:


```SQL

CREATE TABLE jobs (
    job_id INTEGER PRIMARY KEY AUTOINCREMENT, -- Αλλαγή εδώ
    job_title TEXT NOT NULL                   -- Το VARCHAR γίνεται TEXT (προαιρετικά)
);

INSERT INTO jobs (job_title) VALUES ('Software Engineer'), ('HR Manager'), ('Sales Rep');

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT, -- Αλλαγή εδώ
    username TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    job_id INTEGER REFERENCES jobs(job_id),
    password TEXT DEFAULT '1234'
);


```

### 3. Ρύθμιση Σύνδεσης (Context.xml)
Για να τρέξει τοπικά η εφαρμογή, πρέπει να δημιουργήσετε το αρχείο src/main/webapp/META-INF/context.xml (αν δεν υπάρχει) και να προσθέσετε τα δικά σας στοιχεία σύνδεσης:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Context path="/hrproject">
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
