# Write your MySQL query statement below
SELECT s.name
FROM SalesPerson s
WHERE s.sales_id NOT IN
(
    SELECT o.sales_id
    FROM Orders o
    INNER JOIN Company c on o.com_id=c.com_id
    WHERE c.name='RED'
)