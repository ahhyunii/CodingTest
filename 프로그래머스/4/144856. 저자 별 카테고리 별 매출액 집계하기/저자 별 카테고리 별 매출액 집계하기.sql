-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, 
    sum(s.sales * b.price) as total_sales
from book b
join author a on b.author_id = a.author_id
join book_sales s on s.book_id = b.book_id
where s.sales_date between '2022-01-01' and '2022-01-31'
group by b.author_id, a.author_name, b.category
order by b.author_id, b.category desc;