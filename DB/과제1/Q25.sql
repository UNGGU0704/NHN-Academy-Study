select p.koreanname,count(p.personid) 
from appear as a 
		join person as p on p.personid = a.PersonID
where a.roleid = ( select roleid from role where rolename = 'actress' )
group by p.personid, p.koreanname
order by count(p.personid) desc
limit 1;
