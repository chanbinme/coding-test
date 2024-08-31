SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO FI
INNER JOIN FISH_NAME_INFO FNI
ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE 1 = 1
AND FNI.FISH_NAME IN ('BASS', 'SNAPPER')
