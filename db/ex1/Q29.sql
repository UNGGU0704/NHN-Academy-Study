select p.koreanname, count(p.personid)
from person as p
	join appear as a on p.personid = a.personid
where a.roleid in (select roleid from role where rolekorname = '배우')
	 and 
     a.movieid in (select movieid from moviegenre where genreid in (select genreid from genre where genrename = 'drama'))
group by p.koreanname, p.personid
order by count(p.personid) desc
limit 1;
