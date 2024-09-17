WITH A AS (SELECT d1.ID
                FROM DEVELOPERS d1
                    JOIN SKILLCODES s1 ON s1.code & d1.skill_code = s1.code AND s1.category = 'Front End'
                    JOIN SKILLCODES s2 ON s2.code & d1.skill_code = s2.code AND s2.name = 'Python')
,B AS (SELECT d2.ID
            FROM DEVELOPERS d2
                JOIN SKILLCODES s ON s.code & d2.skill_code = s.code AND s.name = 'C#')
,C AS (SELECT d3.ID
            FROM DEVELOPERS d3
                JOIN SKILLCODES s ON s.code & d3.skill_code = s.code AND s.category = 'Front End')
SELECT CASE WHEN ID IN (SELECT ID FROM A) THEN 'A'
            WHEN ID IN (SELECT ID FROM B) THEN 'B'
            WHEN ID IN (SELECT ID FROM C) THEN 'C' 
       END AS 'GRADE',
       ID,
       EMAIL
    FROM DEVELOPERS
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID