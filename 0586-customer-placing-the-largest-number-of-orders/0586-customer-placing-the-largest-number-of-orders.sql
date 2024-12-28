# Write your MySQL query statement below

WITH cte AS 
(SELECT customer_number, COUNT(order_number) AS NumOrd
FROM Orders
GROUP BY customer_number)

SELECT customer_number
FROM cte
WHERE NumOrd=(SELECT Max(NumOrd) FROM cte)

