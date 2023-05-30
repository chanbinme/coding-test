select a.apnt_no apnt_no, p.pt_name pt_name, p.pt_no pt_no, d.mcdp_cd mcdp_cd, d.dr_name dr_name, a.apnt_ymd apnt_ymd
from appointment a
join doctor d
on a.mddr_id = d.dr_id
join patient p
on a.pt_no = p.pt_no
where date_format(a.apnt_ymd,"%Y-%m-%d") = "2022-04-13" 
and A.apnt_cncl_yn ="N" 
and A.mcdp_cd = "CS"
order by apnt_ymd