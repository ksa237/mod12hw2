select
    o.product_name
from public.orders as o
INNER JOIN public.customers as c
ON (o.customer_id = c.id)
where LOWER(c.name) LIKE LOWER(:name);