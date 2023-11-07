select Title
from movie
where  RunningTime > 100 and movieid in (select distinct movieid
				   from appear
					where (personid in (SELECT personid FROM DatamotionMovieDatabase.person where koreanname = '레오나르도 디카프리오')));
