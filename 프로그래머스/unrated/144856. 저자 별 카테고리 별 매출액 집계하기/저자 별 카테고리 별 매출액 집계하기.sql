select a.author_id, a.author_name, b.category, sum(b.price * bs.sales) as total_sales
from book b
join author a 
on b.author_id = a.author_id
join book_sales bs
on b.book_id = bs.book_id
where year(bs.sales_date) = '2022'
and month(bs.sales_date) = '01'
group by a.author_name, b.category
order by a.author_id asc, b.category desc