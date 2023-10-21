select p.koreanname
from person as p
	join appear as a on p.personid = a.personid
where a.roleid in (select roleid from role where rolename = 'director')
	 and 
     a.movieid in (select movieid from moviegenre where genreid in (select genreid from genre where genrename = 'war'))
group by p.koreanname, p.personid
order by count(p.personid) desc
limit 1;

