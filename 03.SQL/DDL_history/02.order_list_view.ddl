-- 회원별 주문내역 뷰
create view order_summary
as
select l.order_no 주문번호, o.member_id 회원명, l.product_name 상품명, l.product_count 주문수량, l.price 청구금액
from products p, orders o,
	(select l.*, l.product_count*p.price_sell price from products p, order_lists l
where l.product_name = p.product_name) l
where o.order_no = l.order_no
group by l.order_no, o.member_id, l.product_name, l.product_count, l.price
order by 주문번호
;

/*
select l.*, l.product_count*p.price_sell price from products p, order_lists l
where l.product_name = p.product_name
;
*/

