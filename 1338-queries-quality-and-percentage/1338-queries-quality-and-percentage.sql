# Write your MySQL query statement below
SELECT QUERY_NAME,ROUND(AVG(RATING/POSITION),2) AS QUALITY,ROUND(AVG(RATING<3)*100,2) AS POOR_QUERY_PERCENTAGE FROM QUERIES GROUP BY QUERY_NAME;