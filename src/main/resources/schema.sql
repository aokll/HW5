CREATE TABLE tasks(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    taskDescription VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    dateOfCreation TIMESTAMP
);