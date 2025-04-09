### Mo on Life
Mo on Life is a personal blog platform where only the admin can create and manage posts. The application is built using Spring Boot, Thymeleaf, and MySQL.


### Features
- Create, edit, and view blog posts.
- Add tags to posts and list popular posts by tags.
- Automatically increment post view count.
- Admin-only access for creating and managing posts.

### Technologies Used
- Backend: Java, Spring Boot, Spring Security, Hibernate
- Frontend: Thymeleaf, HTML, CSS, JavaScript
- Database: MySQL
- Build Tool: Maven

### Setup Instructions
1. Clone the Repository:
```bash
git clone https://github.com/muhammetcnli/Mo-on-Life.git
cd mo-on-life
```


3. Configure the Database:


- Create a MySQL database named blog_db.
- Update the spring.datasource.username and spring.datasource.password fields in the src/main/resources/application.properties file with your MySQL credentials.

3. Install Dependencies:
```bash
mvn clean install
```
4. Run the Application:
```bash   
mvn spring-boot:run
```
5. Access the Application:
- Open your browser and navigate to http://localhost:8080.

### Screenshots

#### Homepage
![HomePage](https://github.com/muhammetcnli/Mo-On-Life/blob/main/Mo-on-Life/src/main/resources/static/images/index.png?raw=true)

#### Login
![LoginPage](https://github.com/muhammetcnli/Mo-On-Life/blob/main/Mo-on-Life/src/main/resources/static/images/login.png?raw=true)

#### Create New Post
![New Post](https://github.com/muhammetcnli/Mo-On-Life/blob/main/Mo-on-Life/src/main/resources/static/images/create.png?raw=true)


#### View Post
![View Post](https://github.com/muhammetcnli/Mo-On-Life/blob/main/Mo-on-Life/src/main/resources/static/images/viewPost.png?raw=true)
