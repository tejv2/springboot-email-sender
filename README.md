#  Spring Boot Email Sender

A lightweight Spring Boot web app that allows users to send emails with attachments and store them in a MySQL database. Deployed on Railway for easy web access.

 **Live App:**  
 [Open Email Form](https://springboot-email-sender-production.up.railway.app/email/form)

---

##  Features

-  Send emails with optional file attachments
-  Save sent emails to a MySQL database
-  View email history
-  Deployed to Railway with persistent backend
-  Secure: Database credentials stored in `.env` (and ignored from Git)

---

## ️ Stack Used

- Java 21
- Spring Boot 3.2
- MySQL (via Railway)
- Thymeleaf
- Hibernate JPA
- Maven

---

##  Run Locally

1. **Clone the repo:**
   ```bash
   git clone https://github.com/tejv2/springboot-email-sender.git
   cd springboot-email-sender
