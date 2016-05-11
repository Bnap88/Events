CREATE TABLE Account
(
  accountId INT IDENTITY PRIMARY KEY,
  accountName VARCHAR(50) UNIQUE,
  accountEmail VARCHAR(50),
  accountPasswordHash VARBINARY(32),
  accountSalt VARBINARY(32),
  accountCreated TIMESTAMP,
  accountActiveState BOOLEAN
)

CREATE TABLE Event
(
  eventId INT IDENTITY PRIMARY KEY,
  creatorAccountId INT,
  eventName VARCHAR(50),
  eventStreetAddress VARCHAR(50),
  eventCity VARCHAR(50),
  eventState CHAR(2),
  eventTime TIMESTAMP,
  CONSTRAINT FK_Event_Account FOREIGN KEY (creatorAccountId) REFERENCES Account (accountId) ON DELETE CASCADE
)

CREATE TABLE Attendance
(
  attendanceId INT IDENTITY PRIMARY KEY,
  accountId INT,
  eventId INT,
  CONSTRAINT FK_Attendance_Account FOREIGN KEY (accountId) REFERENCES Account (accountId) ON DELETE CASCADE,
  CONSTRAINT FK_Attendance_Event FOREIGN KEY (eventId) REFERENCES Event (eventId) ON DELETE CASCADE
)