select p.koreanname
from person as p join appear as a on p.personid = a.personid
				 join awardinvolve as award on a.AppearID = award.appearid
where
    award.WinningID = 2
group by p.koreanname
order by count(p.koreanname) desc
limit 1 offset 1;
