SELECT DISTINCT H.HISTORY_ID, 
        TRUNCATE((C.DAILY_FEE * ((100 - IFNULL(
            (
                SELECT DISCOUNT_RATE
                FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
                WHERE CASE 
                    WHEN (DATEDIFF(H.END_DATE, H.START_DATE) + 1) >= 90 THEN '90일 이상'
                    WHEN (DATEDIFF(H.END_DATE, H.START_DATE) + 1) >= 30 THEN '30일 이상'
                    WHEN (DATEDIFF(H.END_DATE, H.START_DATE) + 1) >= 7 THEN '7일 이상'
                    END = P.DURATION_TYPE
                AND CAR_TYPE = '트럭'
            )
            , 0)) / 100)) * (DATEDIFF(H.END_DATE, H.START_DATE) + 1), 0) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
INNER JOIN CAR_RENTAL_COMPANY_CAR C
ON H.CAR_ID = C.CAR_ID
WHERE 1 = 1
AND C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC