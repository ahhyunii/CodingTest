-- 코드를 입력하세요
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트
select *
from ( -- 대여 금액 계산
    select r.car_id, r.car_type, 
        r.daily_fee * (100 - p.discount_rate)/100 * 30 as fee     
    from ( -- 대여 가능 여부 
        SELECT c.car_id, c.car_type, c.daily_fee
        from car_rental_company_car c
        where (c.car_type = "SUV" or c.car_type = "세단")
        and c.car_id not in (
            select car_id
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY
            where start_date <= "2022-11-30"
            and end_date >= "2022-11-01"
            )
    ) r
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    on r.car_type = p.car_type
    where p.duration_type like "30%"
) t
where fee >= 500000 and fee < 2000000
order by fee desc, car_type, car_id desc;