select p.koreanname
from person p
	join appear a on p.personid = a.personid
	join awardinvolve as award on a.appearid = award.appearid
	join sector as s on award.sectorid = s.SectorID
where s.SectorKorName = '남우주연상' and award.WinningID = 2
GROUP BY p.koreanname
ORDER BY count(p.koreanname) DESC
limit 1;

