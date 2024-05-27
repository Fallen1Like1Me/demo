ALTER TABLE person
ADD CONSTRAINT pasport_id
FOREIGN KEY (pasport_id) REFERENCES pasport(id);

ALTER TABLE person
ADD CONSTRAINT pasport_unique UNIQUE(pasport_id);

ALTER TABLE cars
ADD CONSTRAINT person_id
FOREIGN KEY (person_id) REFERENCES person(id);

ALTER TABLE person_house
ADD CONSTRAINT person_id
FOREIGN KEY (person_id) REFERENCES person(id);

ALTER TABLE person_house
ADD CONSTRAINT house_id
FOREIGN KEY (house_id) REFERENCES houses(id);