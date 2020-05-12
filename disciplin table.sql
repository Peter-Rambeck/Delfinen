create table Delfin.`disciplin` (
  crawl int,
  brystsvoemning int,
  rygcrawl int,
  butterfly int,
  primary key (`disciplinID`));
  
  insert into disciplin (crawl, brystsvoemning, rygcrawl, butterfly )
  value (1);
  insert into disciplin (brystsvoemning)
  value (2);
  insert into disciplin (rygcrawl)
  value (3);
  insert into disciplin (butterfly)
  value (4);
