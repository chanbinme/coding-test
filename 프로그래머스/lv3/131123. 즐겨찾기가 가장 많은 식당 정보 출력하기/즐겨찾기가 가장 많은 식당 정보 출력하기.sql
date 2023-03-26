with maxSet as (
select food_type, max(favorites) as max
from rest_info
group by food_type
)

select r.food_type, r.rest_id, r.rest_name, r.favorites
from rest_info as r
join maxSet as m
where r.favorites = m.max
group by r.food_type
order by r.food_type desc

# select *
# from rest_info 
# where food_type = '일식'
# order by favorites desc