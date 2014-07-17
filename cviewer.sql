create database cviewer; 

use cviewer;                  
                                 

create table photos (
   photoid  int(11) not null auto_increment, 
   clientid int(11) ,
   MAXDown int(11),
   countdown int(11),
   primary key (photoid)  
);


create table clients (
  id int(11) not null auto_increment, 
  rate  int(11),
  lastphotoid int(11),
  imgavailable int(11),
  photodown int(11),
  photoupl int(11),
  primary key (id),
  FOREIGN KEY (lastphotoid) REFERENCES photos (photoid)  
);

create table downloads(
  clientid  int(11) not null, 
  photoid  int(11) not null,  
  time  DATETIME not null, 
  FOREIGN KEY (clientid) REFERENCES clients (id),
  FOREIGN KEY (photoid) REFERENCES photos (photoid)
);

commit;