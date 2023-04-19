# select fh.flavor
# from first_half fh
# join july j
# on fh.flavor = j.flavor
# group by fh.flavor
# order by (sum(fh.total_order + j.total_order) desc
# limit 3

select fh2.flavor
from (select fh.flavor, sum(fh.total_order + j.total_order) total_order
     from first_half fh
     join july j
     on fh.flavor = j.flavor
     group by fh.flavor
     order by total_order desc
     limit 3) as fh2