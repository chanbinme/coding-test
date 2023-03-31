select b.category as category, sum(bs.sales) as total_sales
from book b
left join book_sales bs
on b.book_id = bs.book_id
where Year(bs.sales_date) = 2022
and Month(bs.sales_date) = 1
group by category
order by b.category