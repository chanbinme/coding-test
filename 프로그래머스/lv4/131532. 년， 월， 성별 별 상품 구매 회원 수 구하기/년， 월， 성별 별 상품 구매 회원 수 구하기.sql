select year(os.sales_date) as year, month(os.sales_date) as month, ui.gender as gender, count(distinct os.user_id) users
from user_info ui
right join online_sale os
on ui.user_id = os.user_id
where ui.gender is not null
group by year, gender, month
order by year, month, gender