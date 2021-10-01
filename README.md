# TIC3901 Version Control System Code Contribution 

This project develops a tool to objectively assess relative code contributions by different authors in a version control system. A version control system, like Git, is a software tool that helps software teams manage changes to source code over time. A group of developers utilize this system to collaborate their work over a repository. This project aims to assess each author's modification of the code to quantify their contributions. The project adopts a line-based ownership approach combined with string distance metrics such as the Levenstein distance. For every instance of Git commit, the system compares the current version of the program with the previous version. A result will be generated for every line of code. Each result will be filtered through the Contribution Criteria to determine the ownership of the lines. A collection of ownership of the lines would be stored in the database for review.




Guide for SQlite - Java
https://www.sqlitetutorial.net/sqlite-java/

https://www.tutorialspoint.com/sqlite/sqlite_java.htm
