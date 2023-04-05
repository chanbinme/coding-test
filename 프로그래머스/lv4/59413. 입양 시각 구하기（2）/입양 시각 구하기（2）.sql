with recursive rc as (
    select 0 as hour
    union all
    select hour + 1 from rc where hour < 23
)
select rc.hour, ifnull(ao.count, 0) as count
from (select hour(datetime) as hour, count(datetime) as count
      from animal_outs
      group by hour(datetime)
      ) as ao
right join rc 
on rc.hour = ao.hour
order by rc.hour