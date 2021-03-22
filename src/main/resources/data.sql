insert into book values(1, 'The Tartar Steppe');
insert into book values(2, 'Poem Strip');
insert into book values(3, 'Restless Nights: Selected Stories of Dino Buzzati');

insert into user values('admin','b','c','admin');
insert into user values('user','b','c','user');

insert into property (id,name,property_Type,lease_Type,address,contact_Person,contact_Phone,user_Name,lease_Start_Date,lease_End_Date,cost,time_Unit)
values(1001, 'Flat', 1, 0, 'Mirpur 10', 'Mr. A', '0123456789', null, 2121, 2154, 112.54, 3  ),
(1002, 'House', 0, 0, 'Mirpur 11', 'Mr. B', '0123456789', 'antu', 2121, 2154, 112.54, 3  ),
(1003, 'HOSTEL', 5, 1, 'Mirpur 12', 'Mr. C', '0123456789', null, 2121, 2154, 112.54, 0  ),
(1004, 'OFFICE', 6, 1, 'Mirpur 13', 'Mr. D', '0123456789', 'antu', 2121, 2154, 112.54, 0  ),
(1005, 'Community Center', 8, 2, 'Mirpur 14', 'Mr. E', '0123456789', null, 2121, 2154, 112.54, 3  ),
(1006, 'Shopping Mall', 9, 2, 'Mirpur 15', 'Mr. F', '0123456789', 'antu', 2121, 2154, 112.54, 3  );

insert into PROPERTY_PICTURE_URLS (PROPERTY_ID  	,PICTURE_URLS  )
values(1001,  'http://www.meganscookin.com/wp-content/uploads/2020/08/cash-out-refinance-on-a-rental-property-2020-rate.jpeg'),
(1001,  'https://d3mqmy22owj503.cloudfront.net/10/500410/images/site_graphics/Hero-Slider3.jpg'),
(1001,  'http://www.daytonhomephoto.com/wp-content/uploads/2017/07/WildeFR.png');

insert into PROPERTY_PICTURE_URLS (PROPERTY_ID  	,PICTURE_URLS  )
values(1002,  'http://www.meganscookin.com/wp-content/uploads/2020/08/cash-out-refinance-on-a-rental-property-2020-rate.jpeg'),
(1002,  'https://d3mqmy22owj503.cloudfront.net/10/500410/images/site_graphics/Hero-Slider3.jpg'),
(1002,  'http://www.daytonhomephoto.com/wp-content/uploads/2017/07/WildeFR.png');

insert into PROPERTY_PICTURE_URLS (PROPERTY_ID  	,PICTURE_URLS  )
values(1003,  'http://www.meganscookin.com/wp-content/uploads/2020/08/cash-out-refinance-on-a-rental-property-2020-rate.jpeg'),
(1003,  'https://d3mqmy22owj503.cloudfront.net/10/500410/images/site_graphics/Hero-Slider3.jpg'),
(1003,  'http://www.daytonhomephoto.com/wp-content/uploads/2017/07/WildeFR.png');

insert into PROPERTY_PICTURE_URLS (PROPERTY_ID  	,PICTURE_URLS  )
values(1004,  'http://www.meganscookin.com/wp-content/uploads/2020/08/cash-out-refinance-on-a-rental-property-2020-rate.jpeg'),
(1004,  'https://d3mqmy22owj503.cloudfront.net/10/500410/images/site_graphics/Hero-Slider3.jpg'),
(1004,  'http://www.daytonhomephoto.com/wp-content/uploads/2017/07/WildeFR.png');

insert into PROPERTY_PICTURE_URLS (PROPERTY_ID  	,PICTURE_URLS  )
values(1005,  'http://www.meganscookin.com/wp-content/uploads/2020/08/cash-out-refinance-on-a-rental-property-2020-rate.jpeg'),
(1005,  'https://d3mqmy22owj503.cloudfront.net/10/500410/images/site_graphics/Hero-Slider3.jpg'),
(1005,  'http://www.daytonhomephoto.com/wp-content/uploads/2017/07/WildeFR.png');

insert into PROPERTY_PICTURE_URLS (PROPERTY_ID  	,PICTURE_URLS  )
values(1006,  'http://www.meganscookin.com/wp-content/uploads/2020/08/cash-out-refinance-on-a-rental-property-2020-rate.jpeg'),
(1006,  'https://d3mqmy22owj503.cloudfront.net/10/500410/images/site_graphics/Hero-Slider3.jpg'),
(1006,  'http://www.daytonhomephoto.com/wp-content/uploads/2017/07/WildeFR.png');