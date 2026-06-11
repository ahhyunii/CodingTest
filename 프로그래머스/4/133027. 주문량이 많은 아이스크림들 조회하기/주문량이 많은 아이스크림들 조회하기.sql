-- 코드를 입력하세요
SELECT flavor
from (
    select flavor, sum(total_order) as total
    from (
        select flavor, total_order
        from first_half
        
        union all
        
        select flavor, total_order
        from july
    ) t
    group by flavor
    order by total desc
    limit 3
) t2;