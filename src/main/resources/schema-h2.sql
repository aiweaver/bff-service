-- promotions
DROP TABLE IF EXISTS promotions;
CREATE TABLE promotions (
  id int(11) NOT NULL,
  category varchar(255) NOT NULL,
  content int(11) NOT NULL,
  promotion_month int(11) NOT NULL,
);