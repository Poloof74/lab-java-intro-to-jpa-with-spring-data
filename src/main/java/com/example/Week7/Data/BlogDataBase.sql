CREATE DATABASE BlogDatabase;
USE BlogDatabase;

CREATE TABLE Authors (
                         AuthorID INT PRIMARY KEY AUTO_INCREMENT,
                         AuthorName VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Articles (
                          ArticleID INT PRIMARY KEY AUTO_INCREMENT,
                          Title VARCHAR(200) NOT NULL,
                          WordCount INT NOT NULL,
                          Views INT NOT NULL,
                          AuthorID INT,
                          FOREIGN KEY (AuthorID) REFERENCES Authors (AuthorID)
);

INSERT INTO Authors (AuthorName) VALUES
                                     ('Maria Charlotte'),
                                     ('Juan Perez'),
                                     ('Gemma Alcocer');

INSERT INTO Articles (Title, WordCount, Views, AuthorID) VALUES
                                                             ('Best Paint Colors', 814, 14, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Maria Charlotte')),
                                                             ('Small Space Decorating Tips', 1146, 221, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Juan Perez')),
                                                             ('Hot Accessories', 986, 105, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Maria Charlotte')),
                                                             ('Mixing Textures', 765, 22, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Maria Charlotte')),
                                                             ('Kitchen Refresh', 1242, 307, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Juan Perez')),
                                                             ('Homemade Art Hacks', 1002, 193, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Maria Charlotte')),
                                                             ('Refinishing Wood Floors', 1571, 7542, (SELECT AuthorID FROM Authors WHERE AuthorName = 'Gemma Alcocer'));



CREATE TABLE Customers (
                           CustomerID INT PRIMARY KEY AUTO_INCREMENT,
                           CustomerName VARCHAR(100),
                           CustomerStatus VARCHAR(20),
                           TotalCustomerMileage int not null,
                           UNIQUE (CustomerName)
);


INSERT INTO Customers (CustomerID, CustomerName, CustomerStatus, TotalCustomerMileage) VALUES
                                                                                           (1,'Agustine Riviera', 'Silver',115235),
                                                                                           (2,'Alaina Sepulvida', 'None', 6008),
                                                                                           (3,'Tom Jones', 'Gold',205767),
                                                                                           (4,'Sam Rio', 'None',2653),
                                                                                           (5,'Jessica James', 'Silver',127656),
                                                                                           (6,'Ana Janco', 'Silver',136773),
                                                                                           (7,'Jennifer Cortez', 'Gold',300582),
                                                                                           (8,'Christian Janco', 'Silver',14642);


CREATE TABLE Aircrafts (
                           AircraftID INT PRIMARY KEY AUTO_INCREMENT,
                           Aircraft VARCHAR(50),
                           TotalAircraftSeats INT,
                           UNIQUE (Aircraft)
);


INSERT INTO Aircrafts (AircraftID, Aircraft, TotalAircraftSeats) VALUES
                                                                     (1,'Boeing 747', 400),
                                                                     (2,'Airbus A330', 236),
                                                                     (3,'Boeing 777', 264);

CREATE TABLE Flights (
                         FlightID INT PRIMARY KEY AUTO_INCREMENT,
                         FlightNumber VARCHAR(10),
                         AircraftID INT,
                         FlightMileage INT,
                         FOREIGN KEY (AircraftID) REFERENCES Aircrafts(AircraftID)
);


INSERT INTO Flights ( FlightNumber, AircraftID, FlightMileage) VALUES
                                                                   ('DL143', (SELECT AircraftID FROM Aircrafts WHERE Aircraft = 'Boeing 747'), 135),
                                                                   ('DL122', (SELECT AircraftID FROM Aircrafts WHERE Aircraft = 'Airbus A330'), 4370),
                                                                   ('DL53', (SELECT AircraftID FROM Aircrafts WHERE Aircraft = 'Boeing 777'), 2078),
                                                                   ('DL222', (SELECT AircraftID FROM Aircrafts WHERE Aircraft = 'Boeing 777'), 1765),
                                                                   ('DL37', (SELECT AircraftID FROM Aircrafts WHERE Aircraft = 'Boeing 747'), 531);


CREATE TABLE Bookings (
                          BookingID INT PRIMARY KEY AUTO_INCREMENT,
                          CustomerID INT,
                          CustomerName VARCHAR(100),
                          FlightMileage INT,
                          TotalCustomerMileage INT,
                          FlightNumber VARCHAR(10),
                          FlightID INT,
                          AircraftID INT,
                          FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
                          FOREIGN KEY (FlightID) REFERENCES Flights(FlightID)
);


INSERT INTO Bookings (CustomerID, FlightID ,TotalCustomerMileage) VALUES
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Agustine Riviera'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL143'),115235),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Agustine Riviera'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL122'),115235),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Alaina Sepulvida'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL122'),6008),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Tom Jones'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL122'),205767),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Tom Jones'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL53'),205767),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Tom Jones'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL222'),205767),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Sam Rio'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL143'),2653),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Sam Rio'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL37'),2653),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Jessica James'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL143'),127656),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Jessica James'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL122'),127656),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Ana Janco'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL222'),136773),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Jennifer Cortez'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL222'),300582),
                                                                      ((SELECT CustomerID FROM Customers WHERE CustomerName = 'Christian Janco'), (SELECT FlightID FROM Flights WHERE FlightNumber = 'DL222'),14642);


DROP TABLE Customers;
DROP TABLE Aircrafts;
DROP TABLE flights;
DROP TABLE Bookings;
SELECT COUNT(DISTINCT FlightNumber) FROM flights;

SELECT AVG(FlightMileage) FROM flights;

SELECT AVG(TotalAircraftSeats) FROM aircrafts;

SELECT CustomerStatus, AVG(TotalCustomerMileage) FROM customers GROUP BY CustomerStatus;

SELECT COUNT(*) FROM aircrafts WHERE Aircraft LIKE '%Boeing%';

SELECT * FROM flights WHERE FlightMileage BETWEEN 300 AND 2000;

SELECT c.CustomerStatus, AVG(f.FlightMileage)
FROM bookings b
         JOIN customers c ON b.CustomerID = c.CustomerID
         JOIN flights f ON b.FlightID  = f.FlightID
GROUP BY c.CustomerStatus;

SELECT a.Aircraft, COUNT(*) AS total_bookings
FROM bookings b
         JOIN customers c ON b.CustomerID = c.CustomerID
         JOIN flights f ON b.FlightID  = f.FlightID
         JOIN aircrafts a ON f.AircraftID = a.AircraftID
WHERE c.CustomerStatus = 'Gold'
GROUP BY a.Aircraft
ORDER BY total_bookings DESC
    LIMIT 1;