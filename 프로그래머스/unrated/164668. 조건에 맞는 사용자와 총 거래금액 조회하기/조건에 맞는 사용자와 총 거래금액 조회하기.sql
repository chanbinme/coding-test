select ugu.user_id user_id, ugu.nickname nickname, sum(ugb.price) total_sales
from used_goods_board ugb
join used_goods_user ugu
on ugb.writer_id = ugu.user_id
where ugb.status = "DONE"
group by ugb.writer_id
having total_sales >= 700000
order by total_sales