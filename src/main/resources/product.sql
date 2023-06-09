SELECT o.product_name FROM ORDERS o
                               JOIN  CUSTOMERS C on C.id = o.customer_id
where c.name = lower(:name)