# Write your MySQL query statement below
SELECT PRODUCT_ID,YEAR AS FIRST_YEAR,QUANTITY,PRICE FROM SALES  
WHERE (PRODUCT_ID,YEAR) IN(SELECT PRODUCT_ID, MIN(YEAR) FROM SALES GROUP BY PRODUCT_ID);