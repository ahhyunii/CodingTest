-- 코드를 작성해주세요
with recursive tree as (
    -- 시작점
    select id, parent_id,
        1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    -- 재귀 부분
    select e.id, e.parent_id,
        t.generation + 1
    from ecoli_data e
    join tree t
        on t.id = e.parent_id
)
select count(*) as count, 
    generation
from tree t
where not exists (
    select 1
    from ecoli_data e
    where e.parent_id = t.id
)
group by generation;