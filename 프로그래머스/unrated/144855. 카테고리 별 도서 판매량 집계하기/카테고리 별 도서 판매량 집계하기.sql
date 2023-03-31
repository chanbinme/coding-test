select b.category as category, sum(bs.sales) as total_sales
from book b
left join (
    select *
    from book_sales
    where Year(sales_date) = 2022
    and Month(sales_date) = 1
    ) as bs
on b.book_id = bs.book_id
group by category
order by b.category