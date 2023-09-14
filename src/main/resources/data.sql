CREATE TABLE IF NOT EXISTS alerts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    alertID VARCHAR(255) NOT NULL,
    createdtime VARCHAR(255) NOT NULL,
    env VARCHAR(255) NOT NULL,
    count INT NOT NULL,
    active BOOLEAN NOT NULL,
    severity VARCHAR(255) NOT NULL
);

-- Add a unique constraint to the alertID column
ALTER TABLE alerts
ADD CONSTRAINT UK_alertID UNIQUE (alertID);

-- Insert data into Alerts1
INSERT INTO alerts (alertID, createdtime, env, count, active, severity)
VALUES
  ('ERROR01', '2023-09-14T08:00:00', 'POD1', 10, 'Y', 'CRITICAL'),
  ('ERROR02', '2023-09-14T08:00:00', 'POD2', 15, 'N', 'MEDIUM'),
  ('ERROR03', '2023-09-14T08:00:00', 'POD3', 20, 'Y', 'LOW'),
  
  ('ERROR04', '2023-09-14T08:15:00', 'POD1', 5, 'Y', 'MEDIUM'),
  ('ERROR05', '2023-09-14T08:15:00', 'POD2', 8, 'N', 'CRITICAL'),
  ('ERROR06', '2023-09-14T08:15:00', 'POD3', 12, 'Y', 'LOW'),

  ('ERROR07', '2023-09-14T08:45:00', 'POD1', 18, 'Y', 'CRITICAL'),
  ('ERROR08', '2023-09-14T08:45:00', 'POD2', 25, 'N', 'MEDIUM'),
  ('ERROR09', '2023-09-14T08:45:00', 'POD3', 30, 'Y', 'LOW'),

  ('ERROR010', '2023-09-14T09:00:00', 'POD1', 11, 'N', 'MEDIUM'),
  ('ERROR011', '2023-09-14T09:00:00', 'POD2', 16, 'Y', 'LOW'),
  ('ERROR013', '2023-09-14T09:00:00', 'POD3', 22, 'N', 'CRITICAL'),

  ('ERROR012', '2023-09-14T08:30:00', 'POD1', 7, 'N', 'CRITICAL'),
  ('ERROR014', '2023-09-14T08:30:00', 'POD2', 9, 'Y', 'LOW'),
  ('ERROR015', '2023-09-14T08:30:00', 'POD3', 14, 'N', 'MEDIUM');



-- Create table Alerts1Resolution
CREATE TABLE alerts_resolution (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alertID VARCHAR(255) NOT NULL,
    resolution VARCHAR(1000) NOT NULL,
    team VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL
);


  


-- Insert data into Alerts1Resolution
-- Resolution for ERROR01
INSERT INTO alerts_resolution(alertID, resolution, team, contact)
VALUES
  ('ERROR01', 'Resolution for ERROR01 - Critical Issue', 'TeamA', 'contactA'),
  ('ERROR01', 'Resolution for ERROR01 - Medium Issue', 'TeamB', 'contactB'),
  ('ERROR01', 'Resolution for ERROR01 - Low Issue', 'TeamC', 'contactC');

-- Resolution for ERROR02
INSERT INTO alerts_resolution (alertID, resolution, team, contact)
VALUES
  ('ERROR02', 'Resolution for ERROR02 - Critical Issue', 'TeamX', 'contactX'),
  ('ERROR02', 'Resolution for ERROR02 - Medium Issue', 'TeamY', 'contactY'),
  ('ERROR02', 'Resolution for ERROR02 - Low Issue', 'TeamZ', 'contactZ');

-- Resolution for ERROR03
INSERT INTO alerts_resolution (alertID, resolution, team, contact)
VALUES
  ('ERROR03', 'Resolution for ERROR03 - Critical Issue', 'Team1', 'contact1'),
  ('ERROR03', 'Resolution for ERROR03 - Medium Issue', 'Team2', 'contact2'),
  ('ERROR03', 'Resolution for ERROR03 - Low Issue', 'Team3', 'contact3');
