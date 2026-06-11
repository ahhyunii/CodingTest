-- 코드를 입력하세요
select year(o.sales_date) as year, 
        month(o.sales_date) as month,
        count(distinct u.user_id) as buy_count,
        round(
            count(distinct o.user_id) / 
            (select count(*)
             from user_info
             where joined between "2021-01-01" and "2021-12-31")
            , 1) as purchased_ratio
from user_info u
    left outer join online_sale o 
        on u.user_id = o.user_id
where o.user_id is not null 
    and u.joined between "2021-01-01" and "2021-12-31"
group by year(o.sales_date), month(o.sales_date)
order by year, month;