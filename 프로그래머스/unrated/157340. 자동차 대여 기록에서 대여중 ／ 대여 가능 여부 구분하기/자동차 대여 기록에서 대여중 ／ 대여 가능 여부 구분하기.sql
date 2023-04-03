select car_id,
    case when sum(availability) > 0 then '대여중'
    else '대여 가능' end as availability
from (select car_id, 
    case when '2022-10-16' between start_date and end_date then 1
    else 0 end as availability
    from car_rental_company_rental_history) as temp
group by car_id
order by car_id desc