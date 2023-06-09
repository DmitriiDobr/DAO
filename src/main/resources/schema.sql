
CREATE TABLE CUSTOMERS(
      id serial primary key,
      name varchar(255),
      surname varchar(255),
      age int8,
      phone_number int
);


CREATE TABLE ORDERS(
   id  serial primary key,
   date date,
   customer_id int,
   product_name varchar(255),
   amount int,
   FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)

);