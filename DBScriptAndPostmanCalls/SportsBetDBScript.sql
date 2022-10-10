CREATE DATABASE betgames;

--

CREATE TABLE IF NOT EXISTS Match(
  id SERIAL NOT NULL,
  description varchar(20),
  match_date date,
  match_time time,
  team_a varchar(20),
  team_b varchar(20),
  sport INT,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS MatchOdds(
  id SERIAL,
  match_id  INT NOT NULL,
  specifier char(1) ,
  odd INT,
  PRIMARY KEY (id),
  constraint fk_match_id
     foreign key (match_id) 
     REFERENCES Match(id)
);

--

INSERT INTO Match VALUES
    (1, 'OSFP-PAO', '2021/03/31', '12:00', 'OSFP', 'PAO', 1);

INSERT INTO Match VALUES
    (1, "AEK-PAOK", '2021/03/31', '12:00', 'OSFP', 'PAO', 1);

INSERT INTO MatchOdds VALUES
    (1, 1, 'X', 1.5);

