


select p.koreanname
from person as p join appear as a on p.personid = a.personid
				 join awardinvolve as award on a.AppearID = award.appearid
where a.roleid in (select r.roleid
					from role as r
					where roleid = 6 or roleid = 7)
	and
    award.WinningID = 2
group by p.koreanname
order by count(p.koreanname) desc
limit 1;
