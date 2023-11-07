select title
from movie
where MovieID in (select movieid
			from appear
			where RoleID in (select roleID 
							 from Role
							 where RoleKorName = '감독')
			group by(MovieID)
			having count(movieid) >= 2)
