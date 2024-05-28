Develop a comprehensive FullStack system for managing the Covid database of a Health Maintenance Organization (HMO). 
This system will enable the introduction, editing, and deletion of HMO members, while managing their records in a database

Back-End: -  Powered by the Spring Boot framework, developed in Java.

To set up the back-end of your project, follow these steps:

1.Download and install the JDK (Java Development Kit). 2.(Optional) Use IntelliJ IDEA as your IDE for development. 3.Initialize your project with Spring Boot by entering this link https://start.spring.io/.

Front End:  Developed with the React framework and powered by Vite, a build tool for web projects.

To set up your project, follow these steps:

Initialize your project using Vite: npm create vite@latest name_of_project

Install JavaScript dependencies: npm install

Start the development server to run your React application: npm run dev

For styling, incorporate Bootstrap: npm install bootstrap

In order to make API requests, utilize Axios: npm install axios

For using React Router install react-router-dom package: npm install react-router-dom

Database: Utilize MongoDB Atlas, a fully-managed cloud database solution. No installation is required; simply create a free account. For easy data management, download MongoDB Compass, a GUI for querying, aggregating, and analyzing data.

Demo At the site entrance, a list of all members is displayed. image

When you click on 'Add Member,' you'll be directed to a page where you can input the details of the new member and submit them . image image Upon clicking "Submit," the system verifies the accuracy of the entered details. If any inaccuracies are detected an alert is triggered to notify you. image

It's important to note that the correctness check is specifically applied to first name, last name and id which are the only fileds that mandatory, assuming the correctness of the remaining data. (In addition, a check that the date of recovery is after the date of positive).

After submitting the details, you'll be automatically redirected back to the entrance, where you can access the updated list of all members.

At the main page, apart from adding members, there are three additional options available.

show details - Display information regarding the selected member. image

update - nables you to update the details of an existing member. image

delete - delete a member from the list.
