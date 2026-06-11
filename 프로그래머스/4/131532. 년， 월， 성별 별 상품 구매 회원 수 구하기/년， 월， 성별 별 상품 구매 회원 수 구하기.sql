-- 코드를 입력하세요
SELECT YEAR(o.SALES_DATE) as YEAR, 
    MONTH(o.SALES_DATE) as MONTH, 
    u.gender as GENDER,
    count(distinct u.user_id) as USERS 
from user_info u
join online_sale o on u.user_id = o.user_id
where u.gender is not null
group by YEAR(o.SALES_DATE), MONTH(o.SALES_DATE), u.gender
order by YEAR(o.SALES_DATE), MONTH(o.SALES_DATE), u.gender;