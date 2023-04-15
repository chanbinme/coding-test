select ai.animal_id as animal_id, ai.animal_type as animal_type, ai.name as name
from animal_ins ai
join animal_outs ao
on ai.animal_id = ao.animal_id
where ai.sex_upon_intake != ao.sex_upon_outcome
order by ai.animal_id