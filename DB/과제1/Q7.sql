select Title
from movie
where movieid in (select movieid
				   from appear
					where (personid in (SELECT personid FROM DatamotionMovieDatabase.person where koreanname = '제임스 카메론')) and (roleID in (select roleID from role where RolekorName = '감독')))
	and
    movieid in (select movieid
				from appear
				where personid in ((SELECT personid FROM DatamotionMovieDatabase.person where koreanname = '아놀드 슈워제네거')) and  (roleID in (select roleID from role where RolekorName = '배우')));


