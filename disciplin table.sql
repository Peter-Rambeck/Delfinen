create table Delfin.`disciplin` (
  disciplinID INT NOT NULL AUTO_INCREMENT,
  crawl int,
  brystsvoemning int,
  rygcrawl int,
  butterfly int,
  primary key (`disciplinID`));
  
  insert into disciplin (crawl)
  value (1);
  insert into disciplin (brystsvoemning)
  value (2);
  insert into disciplin (rygcrawl)
  value (3);
  insert into disciplin (butterfly)
  value (4);
