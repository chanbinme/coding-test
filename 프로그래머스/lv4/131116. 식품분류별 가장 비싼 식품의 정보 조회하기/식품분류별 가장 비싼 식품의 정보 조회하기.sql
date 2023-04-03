select category, max(price) as max_price, (
    select product_name
    from food_product
    where p.category = category
    order by price desc limit 1) as product_name
from food_product p
group by category
having category in ('식용유', '국', '김치', '과자')
order by max_price desc