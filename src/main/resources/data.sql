DROP TABLE IF EXISTS user;
CREATE TABLE user (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) DEFAULT NULL,
    role VARCHAR(255) DEFAULT NULL,
    fullname VARCHAR(255) DEFAULT NULL,
    country VARCHAR(255) DEFAULT NULL
);
DELETE FROM user;
INSERT INTO user (username, password, role, fullname, country) VALUES
('admin', '$2a$10$p4hIsc16yCCL55EBrcbZ1e7WIGENRyjJyK32ciGgWwzF8j1uBpkwO', 'ROLE_ADMIN', 'Administrator', 'India'),
('mitesh.parmar', '$2a$10$p4hIsc16yCCL55EBrcbZ1e7WIGENRyjJyK32ciGgWwzF8j1uBpkwO', 'ROLE_USER', 'Mitesh Parmar', 'India');