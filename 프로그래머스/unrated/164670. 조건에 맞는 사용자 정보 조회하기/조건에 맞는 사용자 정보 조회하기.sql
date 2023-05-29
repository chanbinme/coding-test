select ugb.writer_id user_id, ugu.nickname nickname, concat(ugu.city, ' ', ugu.street_address1, ' ', ugu.street_address2) 전체주소, concat(left(ugu.tlno, 3), '-', mid(ugu.tlno, 4, 4), '-', right(ugu.tlno, 4)) 전화번호
from used_goods_board ugb
join used_goods_user ugu
on ugb.writer_id = ugu.user_id
group by ugb.writer_id
having count(*) >= 3
order by ugu.user_id desc