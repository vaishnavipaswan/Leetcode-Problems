# Write your MySQL query statement below
SELECT "Low Salary" AS category,COUNT(ACCOUNT_ID) AS accounts_COUNT  FROM ACCOUNTS WHERE INCOME<20000
UNION
SELECT "Average Salary" AS category,COUNT(ACCOUNT_ID) AS accounts_count FROM ACCOUNTS WHERE INCOME BETWEEN 20000 AND 50000
UNION
SELECT "High Salary" AS category,COUNT(ACCOUNT_ID) AS accounts_count FROM ACCOUNTS WHERE INCOME>50000
ORDER BY accounts_count DESC;