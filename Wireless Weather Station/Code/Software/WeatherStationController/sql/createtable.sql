CREATE TABLE weatherstation(
	StationId VARCHAR(2), 
	StationName VARCHAR(30),
    LocationAddress VARCHAR(200),
    GPSCordinate VARCHAR(50)
);

ALTER TABLE weatherstation
ADD PRIMARY KEY (StationId);

CREATE TABLE sensor(
	SensorId varchar(10),
    SensorName varchar(30),
    ProductUsed varchar(50)
);

ALTER TABLE sensor
ADD PRIMARY KEY (SensorId);

CREATE TABLE sensordata(
	id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id),
    StationId varchar(2),
    SensorId varchar(10),
    SensorReading varchar(10),
    ReadingUnit varchar(5),
    ReadingDateTime datetime
)
AUTO_INCREMENT = 1;

Alter table sensordata
Add constraint fk_sensordata_stationid foreign key (StationId)
references weatherstation (StationId);

Alter table sensordata
Add constraint fk_sensordata_sensorid foreign key (SensorId)
references sensor (SensorId);

CREATE TABLE averagesensordata(
    StationId varchar(2) NOT NULL,
    SensorId varchar(10) NOT NULL,
    ReadingDate Date NOT NULL,
    ReadingHour int NOT NULL,
    
    Slot1Count int(5) default 0,
    Slot1Total varchar(12) default '0',
    Slot1Average varchar(12) default '0',
    Slot2Count int(5) default 0,
    Slot2Total varchar(12) default '0',
    Slot2Average varchar(12) default '0',
    Slot3Count int(5) default 0,
    Slot3Total varchar(12) default '0',
    Slot3Average varchar(12) default '0',
    Slot4Count int(5) default 0,
    Slot4Total varchar(12) default '0',
    Slot4Average varchar(12) default '0',
    Slot5Count int(5) default 0,
    Slot5Total varchar(12) default '0',
    Slot5Average varchar(12) default '0',
    Slot6Count int(5) default 0,
    Slot6Total varchar(12) default '0',
    Slot6Average varchar(12) default '0',
    Slot7Count int(5) default 0,
    Slot7Total varchar(12) default '0',
    Slot7Average varchar(12) default '0',
    Slot8Count int(5) default 0,
    Slot8Total varchar(12) default '0',
    Slot8Average varchar(12) default '0',
    Slot9Count int(5) default 0,
    Slot9Total varchar(12) default '0',
    Slot9Average varchar(12) default '0',
    Slot10Count int(5) default 0,
    Slot10Total varchar(12) default '0',
    Slot10Average varchar(12) default '0',
    Slot11Count int(5) default 0,
    Slot11Total varchar(12) default '0',
    Slot11Average varchar(12) default '0',
    Slot12Count int(5) default 0,
    Slot12Total varchar(12) default '0',
    Slot12Average varchar(12) default '0',
    PRIMARY KEY (StationId, SensorId, ReadingDate, ReadingHour)
);

Alter table averagesensordata
Add constraint fk_averagesensordata_stationid foreign key (StationId)
references weatherstation (StationId);

Alter table averagesensordata
Add constraint fk_averagesensordata_sensorid foreign key (SensorId)
references sensor (SensorId);

CREATE TABLE admin(
	id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id),
	username VARCHAR(30), 
	passcode VARCHAR(10)
)
AUTO_INCREMENT = 1;

