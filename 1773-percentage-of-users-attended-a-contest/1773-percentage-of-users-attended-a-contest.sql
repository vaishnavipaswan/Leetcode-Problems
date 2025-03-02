# Write your MySQL query statement below
SELECT R.CONTEST_ID,ROUND((COUNT(R.USER_ID)/(SELECT COUNT(DISTINCT U.USER_ID)FROM USERS U))*100,2) AS PERCENTAGE FROM USERS U RIGHT JOIN REGISTER R ON U.USER_ID=R.USER_ID GROUP BY R.CONTEST_ID ORDER BY PERCENTAGE DESC,CONTEST_ID ;