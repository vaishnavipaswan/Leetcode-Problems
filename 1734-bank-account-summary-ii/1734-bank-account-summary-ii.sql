# Write your MySQL query statement below
SELECT U.NAME,SUM(T.AMOUNT) AS BALANCE FROM USERS U LEFT JOIN TRANSACTIONS T ON T.ACCOUNT=U.ACCOUNT GROUP BY U.ACCOUNT,U.NAME HAVING SUM(T.AMOUNT)>10000;