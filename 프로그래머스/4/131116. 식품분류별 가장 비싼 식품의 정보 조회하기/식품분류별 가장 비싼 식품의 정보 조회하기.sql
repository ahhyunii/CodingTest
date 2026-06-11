-- 코드를 입력하세요
SELECT category, 
        price as max_price, 
        product_name
from food_product
where (category, price) in ( -- 카테고리별 최댓값을 찾아서 매칭!!
    select category, max(price) -- group by 하기 위해 category 컬럼도 반드시 들고오기!
    from food_product
    group by category
    having category in ("과자", "국", "김치", "식용유")
)
order by max_price desc;