# 자동자 종류가 세단 또는 SUV
# 2022-11-1 ~ 2022-11-30 사이에 대여 가능한 차
# 30일간의 대여 금액이 50만원 이상 200만원 미만 
# 대여 금액 기준 내림차순 -> 자동차 종류 오름차순 -> 자동자 ID 내림차순
select distinct cp.car_id as car_id, cp.car_type as car_type, rental_fee * 30 as fee
from (
    select car.car_id as car_id, car.car_type as car_type, round((car.daily_fee - (car.daily_fee * (plan.discount_rate / 100))), 0) as rental_fee
    from car_rental_company_car car
    join car_rental_company_discount_plan plan
    on car.car_type = plan.car_type
    where plan.duration_type = "30일 이상"
    and car.car_type in ("SUV", "세단")
    ) as cp
join (
        select car.car_id
        from car_rental_company_car car
        join car_rental_company_rental_history history
        on car.car_id = history.car_id
        group by car.car_id
        having max(history.end_date) < date("2022-11-01")
      ) as rc
on cp.car_id = rc.car_id
where rental_fee * 30 between 50000 and 2000000
order by fee desc, car_type, car_id desc